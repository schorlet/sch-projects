package com.hellogin.client.ui;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.hellogin.client.mvp.GoodbyeActivityMapper;
import com.hellogin.client.mvp.HelloActivityMapper;

/**
 * MainView
 */
public class MainView extends Composite {
    private static MainViewUiBinder uiBinder = GWT.create(MainViewUiBinder.class);

    @UiTemplate("MainView.ui.xml")
    interface MainViewUiBinder extends UiBinder<Widget, MainView> {}

    @UiField
    SimplePanel helloPanel;

    @UiField
    SimplePanel goodbyePanel;

    @Inject
    public MainView(final HelloActivityMapper helloActivityMapper,
        final GoodbyeActivityMapper goodbyeActivityMapper, final EventBus eventBus) {

        initWidget(uiBinder.createAndBindUi(this));

        final ActivityManager helloActivityManager = new ActivityManager(helloActivityMapper,
            eventBus);
        helloActivityManager.setDisplay(helloPanel);

        final ActivityManager goodbyeActivityManager = new ActivityManager(goodbyeActivityMapper,
            eventBus);
        goodbyeActivityManager.setDisplay(goodbyePanel);

    }

}