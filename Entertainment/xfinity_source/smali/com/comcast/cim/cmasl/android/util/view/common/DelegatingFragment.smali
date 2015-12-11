.class public Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingFragment;
.super Landroid/app/Fragment;
.source "DelegatingFragment.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private delegateList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-class v0, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingFragment;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingFragment;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 15
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 17
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingFragment;->delegateList:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public onAttach(Landroid/app/Activity;)V
    .locals 3
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 21
    invoke-super {p0, p1}, Landroid/app/Fragment;->onAttach(Landroid/app/Activity;)V

    .line 22
    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingFragment;->delegateList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;

    .line 23
    .local v0, "delegate":Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;
    invoke-interface {v0, p1}, Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;->onAttach(Landroid/app/Activity;)V

    goto :goto_0

    .line 25
    .end local v0    # "delegate":Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 29
    invoke-super {p0, p1}, Landroid/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 30
    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingFragment;->delegateList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;

    .line 31
    .local v0, "delegate":Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;
    invoke-interface {v0}, Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;->onCreate()V

    goto :goto_0

    .line 33
    .end local v0    # "delegate":Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 37
    const/4 v2, 0x0

    .line 39
    .local v2, "view":Landroid/view/View;
    iget-object v3, p0, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingFragment;->delegateList:Ljava/util/List;

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

    check-cast v0, Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;

    .line 40
    .local v0, "delegate":Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;
    if-nez v2, :cond_0

    .line 41
    invoke-interface {v0, p1, p2, p3}, Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v2

    goto :goto_0

    .line 45
    .end local v0    # "delegate":Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;
    :cond_1
    if-nez v2, :cond_2

    .line 46
    invoke-super {p0, p1, p2, p3}, Landroid/app/Fragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v2

    .line 49
    .end local v2    # "view":Landroid/view/View;
    :cond_2
    return-object v2
.end method

.method public onPause()V
    .locals 3

    .prologue
    .line 90
    invoke-super {p0}, Landroid/app/Fragment;->onPause()V

    .line 91
    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingFragment;->delegateList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;

    .line 92
    .local v0, "delegate":Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;
    invoke-interface {v0}, Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;->onPause()V

    goto :goto_0

    .line 94
    .end local v0    # "delegate":Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 4

    .prologue
    .line 70
    invoke-super {p0}, Landroid/app/Fragment;->onResume()V

    .line 72
    const/4 v0, 0x1

    .line 73
    .local v0, "canResume":Z
    iget-object v3, p0, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingFragment;->delegateList:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;

    .line 74
    .local v1, "delegate":Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;
    if-eqz v0, :cond_0

    invoke-interface {v1}, Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;->onResume()Z

    move-result v3

    if-eqz v3, :cond_0

    const/4 v0, 0x1

    .line 75
    :goto_1
    goto :goto_0

    .line 74
    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    .line 77
    .end local v1    # "delegate":Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;
    :cond_1
    if-eqz v0, :cond_2

    .line 78
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingFragment;->onResumeInternal()V

    .line 80
    :cond_2
    return-void
.end method

.method public onResumeInternal()V
    .locals 0

    .prologue
    .line 86
    return-void
.end method

.method public onStart()V
    .locals 3

    .prologue
    .line 54
    invoke-super {p0}, Landroid/app/Fragment;->onStart()V

    .line 55
    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingFragment;->delegateList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;

    .line 56
    .local v0, "delegate":Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;
    invoke-interface {v0}, Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;->onStart()V

    goto :goto_0

    .line 59
    .end local v0    # "delegate":Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingFragment;->onStartInternal()V

    .line 60
    return-void
.end method

.method public onStartInternal()V
    .locals 0

    .prologue
    .line 66
    return-void
.end method

.method public onStop()V
    .locals 3

    .prologue
    .line 98
    invoke-super {p0}, Landroid/app/Fragment;->onStop()V

    .line 99
    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingFragment;->delegateList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;

    .line 100
    .local v0, "delegate":Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;
    invoke-interface {v0}, Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;->onStop()V

    goto :goto_0

    .line 102
    .end local v0    # "delegate":Lcom/comcast/cim/cmasl/android/util/view/common/FragmentDelegate;
    :cond_0
    return-void
.end method
