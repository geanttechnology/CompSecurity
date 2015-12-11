.class public Lco/vine/android/BaseFragment;
.super Landroid/support/v4/app/Fragment;
.source "BaseFragment.java"


# static fields
.field public static final ARG_ACTION:Ljava/lang/String; = "action"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    return-void
.end method

.method public static prepareArguments(Landroid/content/Intent;)Landroid/os/Bundle;
    .locals 3
    .param p0, "intent"    # Landroid/content/Intent;
        .annotation build Lorg/jetbrains/annotations/Nullable;
        .end annotation
    .end param

    .prologue
    .line 29
    if-eqz p0, :cond_1

    .line 31
    invoke-virtual {p0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 32
    .local v0, "args":Landroid/os/Bundle;
    :goto_0
    const-string v1, "action"

    invoke-virtual {p0}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 35
    .end local v0    # "args":Landroid/os/Bundle;
    :goto_1
    return-object v0

    .line 31
    :cond_0
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    goto :goto_0

    .line 35
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method


# virtual methods
.method public onResume()V
    .locals 4

    .prologue
    .line 62
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onResume()V

    .line 63
    const-string v0, "Fragment"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " - "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lco/vine/android/util/CrashUtil;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 64
    invoke-static {}, Lcom/flurry/android/FlurryAgent;->onPageView()V

    .line 65
    return-void
.end method

.method public setActionBarColor()V
    .locals 2

    .prologue
    .line 40
    invoke-virtual {p0}, Lco/vine/android/BaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 41
    .local v0, "activity":Landroid/app/Activity;
    instance-of v1, v0, Lco/vine/android/BaseActionBarActivity;

    if-eqz v1, :cond_0

    .line 42
    check-cast v0, Lco/vine/android/BaseActionBarActivity;

    .end local v0    # "activity":Landroid/app/Activity;
    invoke-virtual {v0}, Lco/vine/android/BaseActionBarActivity;->setActionBarColor()V

    .line 44
    :cond_0
    return-void
.end method

.method public setActionBarColor(I)V
    .locals 2
    .param p1, "color"    # I

    .prologue
    .line 54
    invoke-virtual {p0}, Lco/vine/android/BaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 55
    .local v0, "activity":Landroid/app/Activity;
    instance-of v1, v0, Lco/vine/android/BaseActionBarActivity;

    if-eqz v1, :cond_0

    .line 56
    check-cast v0, Lco/vine/android/BaseActionBarActivity;

    .end local v0    # "activity":Landroid/app/Activity;
    invoke-virtual {v0, p1}, Lco/vine/android/BaseActionBarActivity;->setActionBarColor(I)V

    .line 58
    :cond_0
    return-void
.end method

.method public setActionBarTransition(Landroid/graphics/drawable/TransitionDrawable;)V
    .locals 2
    .param p1, "td"    # Landroid/graphics/drawable/TransitionDrawable;

    .prologue
    .line 47
    invoke-virtual {p0}, Lco/vine/android/BaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 48
    .local v0, "activity":Landroid/app/Activity;
    instance-of v1, v0, Lco/vine/android/BaseActionBarActivity;

    if-eqz v1, :cond_0

    .line 49
    check-cast v0, Lco/vine/android/BaseActionBarActivity;

    .end local v0    # "activity":Landroid/app/Activity;
    invoke-virtual {v0, p1}, Lco/vine/android/BaseActionBarActivity;->setActionBarTransition(Landroid/graphics/drawable/TransitionDrawable;)V

    .line 51
    :cond_0
    return-void
.end method
