.class public Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingPreferenceActivity;
.super Landroid/preference/PreferenceActivity;
.source "DelegatingPreferenceActivity.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private delegateList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-class v0, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingPreferenceActivity;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingPreferenceActivity;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 15
    invoke-direct {p0}, Landroid/preference/PreferenceActivity;-><init>()V

    .line 17
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingPreferenceActivity;->delegateList:Ljava/util/List;

    return-void
.end method


# virtual methods
.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 3
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 103
    invoke-super {p0, p1, p2, p3}, Landroid/preference/PreferenceActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 104
    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingPreferenceActivity;->delegateList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;

    .line 105
    .local v0, "activityDelegate":Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;
    invoke-interface {v0, p1, p2, p3}, Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;->onActivityResult(IILandroid/content/Intent;)V

    goto :goto_0

    .line 107
    .end local v0    # "activityDelegate":Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;
    :cond_0
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 21
    invoke-super {p0, p1}, Landroid/preference/PreferenceActivity;->onCreate(Landroid/os/Bundle;)V

    .line 22
    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingPreferenceActivity;->delegateList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;

    .line 23
    .local v0, "activityDelegate":Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;
    invoke-interface {v0}, Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;->onCreate()V

    goto :goto_0

    .line 25
    .end local v0    # "activityDelegate":Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;
    :cond_0
    return-void
.end method

.method public onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .locals 4
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 29
    const/4 v2, 0x0

    .line 31
    .local v2, "view":Landroid/view/View;
    iget-object v3, p0, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingPreferenceActivity;->delegateList:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;

    .line 32
    .local v0, "activityDelegate":Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;
    if-nez v2, :cond_0

    .line 33
    invoke-interface {v0, p1, p2, p3}, Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;->onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v2

    goto :goto_0

    .line 37
    .end local v0    # "activityDelegate":Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;
    :cond_1
    if-nez v2, :cond_2

    .line 38
    invoke-super {p0, p1, p2, p3}, Landroid/preference/PreferenceActivity;->onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v2

    .line 41
    .end local v2    # "view":Landroid/view/View;
    :cond_2
    return-object v2
.end method

.method protected onPause()V
    .locals 3

    .prologue
    .line 87
    invoke-super {p0}, Landroid/preference/PreferenceActivity;->onStart()V

    .line 88
    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingPreferenceActivity;->delegateList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;

    .line 89
    .local v0, "activityDelegate":Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;
    invoke-interface {v0}, Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;->onPause()V

    goto :goto_0

    .line 91
    .end local v0    # "activityDelegate":Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 5

    .prologue
    .line 62
    invoke-super {p0}, Landroid/preference/PreferenceActivity;->onResume()V

    .line 64
    const/4 v1, 0x1

    .line 65
    .local v1, "canResume":Z
    iget-object v4, p0, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingPreferenceActivity;->delegateList:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;

    .line 66
    .local v0, "activityDelegate":Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;
    invoke-interface {v0}, Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;->onResume()Z

    move-result v3

    .line 67
    .local v3, "resumeSucceeded":Z
    if-eqz v1, :cond_3

    if-eqz v3, :cond_3

    const/4 v1, 0x1

    .line 69
    :goto_0
    if-nez v3, :cond_0

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;->isBlocking()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 74
    .end local v0    # "activityDelegate":Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;
    .end local v3    # "resumeSucceeded":Z
    :cond_1
    if-eqz v1, :cond_2

    .line 75
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingPreferenceActivity;->onResumeInternal()V

    .line 77
    :cond_2
    return-void

    .line 67
    .restart local v0    # "activityDelegate":Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;
    .restart local v3    # "resumeSucceeded":Z
    :cond_3
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public onResumeInternal()V
    .locals 0

    .prologue
    .line 83
    return-void
.end method

.method protected onStart()V
    .locals 3

    .prologue
    .line 46
    invoke-super {p0}, Landroid/preference/PreferenceActivity;->onStart()V

    .line 47
    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingPreferenceActivity;->delegateList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;

    .line 48
    .local v0, "activityDelegate":Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;
    invoke-interface {v0}, Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;->onStart()V

    goto :goto_0

    .line 51
    .end local v0    # "activityDelegate":Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingPreferenceActivity;->onStartInternal()V

    .line 52
    return-void
.end method

.method public onStartInternal()V
    .locals 0

    .prologue
    .line 58
    return-void
.end method

.method protected onStop()V
    .locals 3

    .prologue
    .line 95
    invoke-super {p0}, Landroid/preference/PreferenceActivity;->onStart()V

    .line 96
    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingPreferenceActivity;->delegateList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;

    .line 97
    .local v0, "activityDelegate":Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;
    invoke-interface {v0}, Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;->onStop()V

    goto :goto_0

    .line 99
    .end local v0    # "activityDelegate":Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;
    :cond_0
    return-void
.end method
