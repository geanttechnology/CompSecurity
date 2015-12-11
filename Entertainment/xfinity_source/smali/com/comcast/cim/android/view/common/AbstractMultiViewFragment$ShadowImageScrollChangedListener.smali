.class Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$ShadowImageScrollChangedListener;
.super Ljava/lang/Object;
.source "AbstractMultiViewFragment.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/android/util/view/widget/OnObservableScrollChangedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ShadowImageScrollChangedListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;


# direct methods
.method private constructor <init>(Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;)V
    .locals 0

    .prologue
    .line 112
    .local p0, "this":Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$ShadowImageScrollChangedListener;, "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment<TI;TT;>.ShadowImageScrollChangedListener;"
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$ShadowImageScrollChangedListener;->this$0:Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;
    .param p2, "x1"    # Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$1;

    .prologue
    .line 112
    .local p0, "this":Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$ShadowImageScrollChangedListener;, "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment<TI;TT;>.ShadowImageScrollChangedListener;"
    invoke-direct {p0, p1}, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$ShadowImageScrollChangedListener;-><init>(Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;)V

    return-void
.end method


# virtual methods
.method public onObservableScrollChanged(Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView;IIII)V
    .locals 2
    .param p1, "scrollView"    # Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "oldx"    # I
    .param p5, "oldy"    # I

    .prologue
    .line 115
    .local p0, "this":Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$ShadowImageScrollChangedListener;, "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment<TI;TT;>.ShadowImageScrollChangedListener;"
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$ShadowImageScrollChangedListener;->this$0:Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;

    iget-object v0, v0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->shadowImage:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    .line 116
    if-nez p3, :cond_1

    .line 117
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$ShadowImageScrollChangedListener;->this$0:Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;

    iget-object v0, v0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->shadowImage:Landroid/widget/ImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 122
    :cond_0
    :goto_0
    return-void

    .line 119
    :cond_1
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$ShadowImageScrollChangedListener;->this$0:Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;

    iget-object v0, v0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->shadowImage:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0
.end method
