.class public Lco/vine/android/ViewOverlayActivity;
.super Lco/vine/android/BaseControllerActionBarActivity;
.source "ViewOverlayActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# static fields
.field private static final EXTRA_CALL_TO_ACTION_ID:Ljava/lang/String; = "call_to_action_id"

.field private static final EXTRA_LAYOUT:Ljava/lang/String; = "layout"

.field private static final EXTRA_SKIP_ID:Ljava/lang/String; = "skip_id"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Lco/vine/android/BaseControllerActionBarActivity;-><init>()V

    return-void
.end method

.method public static getIntent(Landroid/content/Context;III)Landroid/content/Intent;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "layout"    # I
    .param p2, "callToActionId"    # I
    .param p3, "skipButtonId"    # I

    .prologue
    .line 79
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/ViewOverlayActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 80
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "layout"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 81
    const-string v1, "call_to_action_id"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 82
    const-string v1, "skip_id"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 83
    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v3, -0x1

    .line 56
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    .line 75
    :goto_0
    return-void

    .line 58
    :sswitch_0
    invoke-static {p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "pref_gb_notif_dismissed"

    const/4 v2, 0x1

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 60
    invoke-virtual {p0, v3}, Lco/vine/android/ViewOverlayActivity;->setResult(I)V

    .line 61
    invoke-virtual {p0}, Lco/vine/android/ViewOverlayActivity;->finish()V

    goto :goto_0

    .line 65
    :sswitch_1
    invoke-virtual {p0, v3}, Lco/vine/android/ViewOverlayActivity;->setResult(I)V

    .line 66
    invoke-virtual {p0}, Lco/vine/android/ViewOverlayActivity;->finish()V

    goto :goto_0

    .line 70
    :sswitch_2
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lco/vine/android/ViewOverlayActivity;->setResult(I)V

    .line 71
    invoke-virtual {p0}, Lco/vine/android/ViewOverlayActivity;->finish()V

    goto :goto_0

    .line 56
    nop

    :sswitch_data_0
    .sparse-switch
        0x7f0a008a -> :sswitch_2
        0x7f0a011f -> :sswitch_0
        0x7f0a0236 -> :sswitch_1
    .end sparse-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 8
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 25
    invoke-virtual {p0}, Lco/vine/android/ViewOverlayActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    .line 26
    .local v2, "intent":Landroid/content/Intent;
    invoke-virtual {v2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v5

    if-nez v5, :cond_0

    .line 27
    new-instance v5, Ljava/lang/IllegalStateException;

    const-string v6, "Extras bundle must not be null; use this class\'s getIntent() helper."

    invoke-direct {v5, v6}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 30
    :cond_0
    const-string v5, "layout"

    invoke-virtual {v2, v5, v7}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v3

    .line 31
    .local v3, "layoutId":I
    if-ge v3, v6, :cond_1

    .line 32
    new-instance v5, Ljava/lang/IllegalStateException;

    const-string v6, "You must provide a layout id when starting this Activity"

    invoke-direct {v5, v6}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 34
    :cond_1
    invoke-super {p0, p1, v3, v6}, Lco/vine/android/BaseControllerActionBarActivity;->onCreate(Landroid/os/Bundle;IZ)V

    .line 36
    sget v5, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v6, 0xe

    if-gt v5, v6, :cond_2

    .line 37
    invoke-virtual {p0}, Lco/vine/android/ViewOverlayActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    .line 38
    .local v0, "ab":Landroid/support/v7/app/ActionBar;
    if-eqz v0, :cond_2

    .line 39
    invoke-virtual {v0}, Landroid/support/v7/app/ActionBar;->hide()V

    .line 43
    .end local v0    # "ab":Landroid/support/v7/app/ActionBar;
    :cond_2
    const-string v5, "call_to_action_id"

    invoke-virtual {v2, v5, v7}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v5

    invoke-virtual {p0, v5}, Lco/vine/android/ViewOverlayActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 44
    .local v1, "cta":Landroid/view/View;
    if-eqz v1, :cond_3

    .line 45
    invoke-virtual {v1, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 48
    :cond_3
    const-string v5, "skip_id"

    invoke-virtual {v2, v5, v7}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v5

    invoke-virtual {p0, v5}, Lco/vine/android/ViewOverlayActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 49
    .local v4, "skip":Landroid/view/View;
    if-eqz v4, :cond_4

    .line 50
    invoke-virtual {v4, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 52
    :cond_4
    return-void
.end method
