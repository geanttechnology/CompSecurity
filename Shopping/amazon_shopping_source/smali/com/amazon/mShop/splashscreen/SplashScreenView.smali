.class public Lcom/amazon/mShop/splashscreen/SplashScreenView;
.super Landroid/widget/RelativeLayout;
.source "SplashScreenView.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 10
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 11
    return-void
.end method


# virtual methods
.method protected onAttachedToWindow()V
    .locals 3

    .prologue
    .line 15
    invoke-super {p0}, Landroid/widget/RelativeLayout;->onAttachedToWindow()V

    .line 16
    invoke-virtual {p0}, Lcom/amazon/mShop/splashscreen/SplashScreenView;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 17
    .local v1, "context":Landroid/content/Context;
    instance-of v2, v1, Lcom/amazon/mShop/splashscreen/StartupActivity;

    if-eqz v2, :cond_0

    move-object v0, v1

    .line 21
    check-cast v0, Lcom/amazon/mShop/splashscreen/StartupActivity;

    .line 22
    .local v0, "activity":Lcom/amazon/mShop/splashscreen/StartupActivity;
    invoke-virtual {v0}, Lcom/amazon/mShop/splashscreen/StartupActivity;->getStartupMediator()Lcom/amazon/mShop/startup/StartupSequenceMediator;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->start()V

    .line 25
    .end local v0    # "activity":Lcom/amazon/mShop/splashscreen/StartupActivity;
    :cond_0
    return-void
.end method
