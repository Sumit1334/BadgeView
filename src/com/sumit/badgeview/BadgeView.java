package com.sumit.badgeview;

import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.sumit.badgeview.lib.QBadgeView;

import java.io.IOException;
import java.util.HashMap;

public class BadgeView extends AndroidNonvisibleComponent implements Component {
    private final Activity activity;
    private final HashMap<String, QBadgeView> badgeViews = new HashMap<>();

    public BadgeView(ComponentContainer container) {
        super(container.$form());
        this.activity = container.$context();
        Log.i("BadgeView", "Initialized");
    }

    @SimpleFunction(description = "Creates a badge")
    public void CreateBadge(String id, AndroidViewComponent view) {
        QBadgeView badgeView = new QBadgeView(activity);
        badgeView.bindTarget(view.getView());
        badgeViews.put(id, badgeView);
    }

    @SimpleFunction(description = "set the gravity of the badge")
    public void SetGravity(String id, int gravity) {
        badgeViews.get(id).setBadgeGravity(gravity);
    }

    @SimpleProperty
    public int CenterHorizontal() {
        return Gravity.CENTER_HORIZONTAL;
    }

    @SimpleProperty
    public int CenterVertical() {
        return Gravity.CENTER_VERTICAL;
    }

    @SimpleProperty
    public int Top() {
        return Gravity.TOP;
    }

    @SimpleProperty
    public int Bottom() {
        return Gravity.BOTTOM;
    }

    @SimpleProperty
    public int Start() {
        return Gravity.START;
    }

    @SimpleProperty
    public int End() {
        return Gravity.END;
    }

    @SimpleFunction(description = "set the text to the badge view")
    public void SetText(String id, String text) {
        badgeViews.get(id).setBadgeText(text);
    }

    @SimpleFunction(description = "set the text color of the badge")
    public void SetTextColor(String id, int color) {
        badgeViews.get(id).setBadgeTextColor(color);
    }

    @SimpleFunction(description = "set the text size of the badge")
    public void SetTextSize(String id, float size) {
        badgeViews.get(id).setBadgeTextSize(size, true);
    }

    @SimpleFunction(description = "set the background of the badge")
    public void SetBackgroundImage(String id, String image) throws IOException {
        badgeViews.get(id).setBadgeBackground(MediaUtil.getBitmapDrawable(form, image));
    }

    @SimpleFunction(description = "set the background color of the image")
    public void SetBackgroundColor(String id, int color) {
        badgeViews.get(id).setBadgeBackgroundColor(color);
    }

    @SimpleFunction(description = "set the padding of the badge")
    public void SetPadding(String id, int padding) {
        badgeViews.get(id).setBadgePadding(padding, false);
    }

    @SimpleFunction(description = "hide the badge")
    public void Hide(String id, boolean animate) {
        badgeViews.get(id).hide(animate);
    }

    @SimpleFunction(description = "set the properties with one block")
    public void Set(String id, int gravity, String text, int textColor, float textSize, String bgImage, int bgColor, int padding) throws IOException {
        SetGravity(id, gravity);
        SetText(id, text);
        SetTextColor(id, textColor);
        SetTextSize(id, textSize);
        SetBackgroundImage(id, bgImage);
        SetBackgroundColor(id, bgColor);
        SetPadding(id, padding);
    }
}
