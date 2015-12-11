.class public abstract Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;
.super Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;
.source "AbstractMultiViewFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;,
        Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$ShadowImageScrollChangedListener;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<I:",
        "Ljava/lang/Object;",
        "T:",
        "Landroid/view/ViewGroup;",
        ">",
        "Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field protected alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

.field protected bodyContainer:Landroid/view/ViewGroup;

.field protected infoMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment",
            "<TI;TT;>.com/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;>;"
        }
    .end annotation
.end field

.field private final internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

.field private layoutInflator:Landroid/view/LayoutInflater;

.field private loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

.field protected shadowImage:Landroid/widget/ImageView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 28
    const-class v0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 26
    .local p0, "this":Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;, "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment<TI;TT;>;"
    invoke-direct {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;-><init>()V

    .line 29
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 39
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .line 144
    return-void
.end method


# virtual methods
.method protected abstract getInfoMap(Landroid/view/LayoutInflater;)Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/LayoutInflater;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment",
            "<TI;TT;>.com/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;>;"
        }
    .end annotation
.end method

.method protected abstract getLayoutId()I
.end method

.method public getLoadingViewDelegate()Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;
    .locals 1

    .prologue
    .line 126
    .local p0, "this":Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;, "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment<TI;TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    return-object v0
.end method

.method protected abstract getShadowImageId()I
.end method

.method protected abstract initInfoView(ILcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment",
            "<TI;TT;>.com/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;)V"
        }
    .end annotation
.end method

.method protected initInfoViews()V
    .locals 4

    .prologue
    .line 81
    .local p0, "this":Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;, "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment<TI;TT;>;"
    iget-object v2, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->layoutInflator:Landroid/view/LayoutInflater;

    invoke-virtual {p0, v2}, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->getInfoMap(Landroid/view/LayoutInflater;)Ljava/util/Map;

    move-result-object v2

    iput-object v2, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->infoMap:Ljava/util/Map;

    .line 82
    iget-object v2, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->infoMap:Ljava/util/Map;

    if-eqz v2, :cond_0

    .line 83
    iget-object v2, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->infoMap:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 84
    .local v0, "e":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Integer;Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment<TI;TT;>.AdapterViewInfo;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;

    .line 85
    .local v1, "info":Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;, "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment<TI;TT;>.AdapterViewInfo;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-virtual {p0, v2, v1}, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->initInfoView(ILcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;)V

    goto :goto_0

    .line 88
    .end local v0    # "e":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Integer;Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment<TI;TT;>.AdapterViewInfo;>;"
    .end local v1    # "info":Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;, "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment<TI;TT;>.AdapterViewInfo;"
    :cond_0
    return-void
.end method

.method protected abstract loadResources()V
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 45
    .local p0, "this":Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;, "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment<TI;TT;>;"
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onAttach(Landroid/app/Activity;)V

    .line 46
    check-cast p1, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .line 47
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 51
    .local p0, "this":Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;, "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment<TI;TT;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->getLayoutId()I

    move-result v2

    const/4 v3, 0x0

    invoke-virtual {p1, v2, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 53
    .local v0, "rootView":Landroid/view/ViewGroup;
    sget v2, Lcom/comcast/cim/android/R$id;->body_container:I

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    iput-object v2, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->bodyContainer:Landroid/view/ViewGroup;

    .line 55
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->getShadowImageId()I

    move-result v1

    .line 56
    .local v1, "shadowImageId":I
    if-eqz v1, :cond_0

    .line 57
    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->shadowImage:Landroid/widget/ImageView;

    .line 59
    iget-object v2, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->bodyContainer:Landroid/view/ViewGroup;

    check-cast v2, Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView;

    new-instance v3, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$ShadowImageScrollChangedListener;

    const/4 v4, 0x0

    invoke-direct {v3, p0, v4}, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$ShadowImageScrollChangedListener;-><init>(Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$1;)V

    invoke-virtual {v2, v3}, Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView;->setOnObservableScrollChangedListener(Lcom/comcast/cim/cmasl/android/util/view/widget/OnObservableScrollChangedListener;)V

    .line 61
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->layoutInflator:Landroid/view/LayoutInflater;

    .line 63
    invoke-virtual {p0, v0}, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->setupLoadingViewDelegate(Landroid/view/ViewGroup;)V

    .line 64
    return-object v0
.end method

.method public onDestroyView()V
    .locals 2

    .prologue
    .line 106
    .local p0, "this":Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;, "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment<TI;TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->bodyContainer:Landroid/view/ViewGroup;

    instance-of v0, v0, Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView;

    if-eqz v0, :cond_0

    .line 107
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->bodyContainer:Landroid/view/ViewGroup;

    check-cast v0, Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView;->setOnObservableScrollChangedListener(Lcom/comcast/cim/cmasl/android/util/view/widget/OnObservableScrollChangedListener;)V

    .line 109
    :cond_0
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onDestroyView()V

    .line 110
    return-void
.end method

.method public onStartInternal()V
    .locals 1

    .prologue
    .line 94
    .local p0, "this":Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;, "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment<TI;TT;>;"
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onStartInternal()V

    .line 95
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onStart()V

    .line 96
    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 100
    .local p0, "this":Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;, "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment<TI;TT;>;"
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onStop()V

    .line 101
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onStop()V

    .line 102
    return-void
.end method

.method protected setupLoadingViewDelegate(Landroid/view/ViewGroup;)V
    .locals 6
    .param p1, "layout"    # Landroid/view/ViewGroup;

    .prologue
    .line 68
    .local p0, "this":Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;, "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment<TI;TT;>;"
    sget v0, Lcom/comcast/cim/android/R$id;->body_container:I

    invoke-virtual {p1, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    .line 69
    .local v2, "bodyContainer":Landroid/view/ViewGroup;
    sget v0, Lcom/comcast/cim/android/R$id;->loading_indicator:I

    invoke-virtual {p1, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;

    .line 71
    .local v3, "loadingIndicator":Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;
    new-instance v0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iget-object v4, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    new-instance v5, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$1;

    invoke-direct {v5, p0}, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$1;-><init>(Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;)V

    invoke-direct/range {v0 .. v5}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;-><init>(Landroid/app/Activity;Landroid/view/ViewGroup;Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$ReadyListener;)V

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    .line 77
    return-void
.end method

.method protected updateAdapterFromList(Ljava/lang/Integer;Ljava/util/List;)V
    .locals 3
    .param p1, "absListViewId"    # Ljava/lang/Integer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Integer;",
            "Ljava/util/List",
            "<TI;>;)V"
        }
    .end annotation

    .prologue
    .line 131
    .local p0, "this":Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;, "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment<TI;TT;>;"
    .local p2, "list":Ljava/util/List;, "Ljava/util/List<TI;>;"
    iget-object v2, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->infoMap:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;

    .line 132
    .local v1, "info":Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;, "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment<TI;TT;>.AdapterViewInfo;"
    iget-object v0, v1, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;->adapter:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;

    .line 134
    .local v0, "adapter":Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;, "Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter<TI;*>;"
    if-eqz v0, :cond_0

    .line 135
    invoke-virtual {v0, p2}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;->setEntities(Ljava/util/List;)V

    .line 136
    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;->getCount()I

    move-result v2

    if-lez v2, :cond_1

    .line 137
    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;->notifyDataSetChanged()V

    .line 142
    :cond_0
    :goto_0
    return-void

    .line 139
    :cond_1
    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;->notifyDataSetInvalidated()V

    goto :goto_0
.end method
