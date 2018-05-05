package ru.for3n.picture;

import android.support.v4.view.ViewPager;
import android.view.View;

public class DepthPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.75f;

    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();

        if (position < -1) { // [-Infinity,-1)
            // Страница находится за пределами экрана слева
            view.setAlpha(0);

        } else if (position <= 0) { // [-1,0]
            // Переход слайдов по умолчанию при перемещении на левую страницу
            view.setAlpha(1);
            view.setTranslationX(0);
            view.setScaleX(1);
            view.setScaleY(1);

        } else if (position <= 1) { // (0,1]
            // Затухание страницы.
            view.setAlpha(1 - position);

            // Противодействие переходу слайдов по умолчанию
            view.setTranslationX(pageWidth * -position);

            // Масштабировать страницу вниз (между MIN_SCALE и 1)
            float scaleFactor = MIN_SCALE
                    + (1 - MIN_SCALE) * (1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

        } else { // (1,+Infinity]
            // Эта страница находится за пределами экрана справа
            view.setAlpha(0);
        }
    }

}
