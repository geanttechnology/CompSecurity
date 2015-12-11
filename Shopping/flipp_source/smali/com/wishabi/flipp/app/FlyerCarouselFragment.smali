.class public Lcom/wishabi/flipp/app/FlyerCarouselFragment;
.super Landroid/app/Fragment;
.source "SourceFile"

# interfaces
.implements Landroid/app/LoaderManager$LoaderCallbacks;
.implements Lcom/wishabi/flipp/app/dq;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/app/Fragment;",
        "Landroid/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;",
        "Lcom/wishabi/flipp/app/dq;"
    }
.end annotation


# static fields
.field private static final k:Ljava/lang/String;


# instance fields
.field private A:Z

.field private B:Z

.field private C:Z

.field private D:Z

.field private E:Z

.field final a:Landroid/support/v4/view/ch;

.field b:Lcom/wishabi/flipp/app/bn;

.field c:Landroid/os/Bundle;

.field d:[Landroid/os/Parcelable;

.field e:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

.field f:I

.field g:Z

.field h:Ljava/lang/String;

.field i:Ljava/lang/Integer;

.field j:I

.field private final l:Lcom/wishabi/flipp/widget/bh;

.field private final m:Lcom/wishabi/flipp/widget/dr;

.field private n:Z

.field private o:Landroid/view/View;

.field private p:Lcom/wishabi/flipp/widget/FlyerToolbar;

.field private q:Lcom/wishabi/flipp/widget/ShoppingListPopup;

.field private r:I

.field private s:Landroid/widget/Toast;

.field private t:Landroid/view/Menu;

.field private u:Landroid/view/MenuItem;

.field private v:Landroid/view/MenuItem;

.field private w:Z

.field private x:Z

.field private y:Lcom/wishabi/flipp/content/Flyer$Model;

.field private z:Lcom/wishabi/flipp/app/bo;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 60
    const-class v0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->k:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 52
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 80
    new-instance v0, Lcom/wishabi/flipp/app/bf;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/bf;-><init>(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->l:Lcom/wishabi/flipp/widget/bh;

    .line 178
    new-instance v0, Lcom/wishabi/flipp/app/bg;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/bg;-><init>(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->m:Lcom/wishabi/flipp/widget/dr;

    .line 209
    new-instance v0, Lcom/wishabi/flipp/app/bh;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/bh;-><init>(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a:Landroid/support/v4/view/ch;

    .line 317
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/FlyerCarouselFragment;Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/app/bo;
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->z:Lcom/wishabi/flipp/app/bo;

    return-object p1
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/FlyerCarouselFragment;Lcom/wishabi/flipp/content/Flyer$Model;)Lcom/wishabi/flipp/content/Flyer$Model;
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->y:Lcom/wishabi/flipp/content/Flyer$Model;

    return-object p1
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/FlyerCarouselFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->h:Ljava/lang/String;

    return-object p1
.end method

.method private a()V
    .locals 7

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 752
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->z:Lcom/wishabi/flipp/app/bo;

    if-nez v0, :cond_0

    .line 789
    :goto_0
    return-void

    .line 755
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->z:Lcom/wishabi/flipp/app/bo;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/bo;->getView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/FlyerViewGroup;

    .line 757
    if-nez v0, :cond_1

    .line 758
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->p:Lcom/wishabi/flipp/widget/FlyerToolbar;

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/FlyerToolbar;->setForwardEnabled(Z)V

    .line 759
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->p:Lcom/wishabi/flipp/widget/FlyerToolbar;

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/FlyerToolbar;->setBackwardEnabled(Z)V

    goto :goto_0

    .line 763
    :cond_1
    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getHighlightAnnotations()Ljava/util/List;

    move-result-object v3

    .line 764
    if-eqz v3, :cond_2

    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 765
    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->p:Lcom/wishabi/flipp/widget/FlyerToolbar;

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/FlyerToolbar;->setForwardEnabled(Z)V

    .line 766
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->p:Lcom/wishabi/flipp/widget/FlyerToolbar;

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/FlyerToolbar;->setBackwardEnabled(Z)V

    goto :goto_0

    .line 770
    :cond_3
    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getVisibleRect()Landroid/graphics/RectF;

    move-result-object v4

    .line 773
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_4
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_7

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/bi;

    .line 774
    iget-object v0, v0, Lcom/wishabi/flipp/widget/bi;->a:Landroid/graphics/RectF;

    iget v0, v0, Landroid/graphics/RectF;->left:F

    iget v6, v4, Landroid/graphics/RectF;->right:F

    cmpl-float v0, v0, v6

    if-lez v0, :cond_4

    move v0, v1

    .line 779
    :goto_1
    iget-object v5, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->p:Lcom/wishabi/flipp/widget/FlyerToolbar;

    invoke-virtual {v5, v0}, Lcom/wishabi/flipp/widget/FlyerToolbar;->setForwardEnabled(Z)V

    .line 782
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_5
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/bi;

    .line 783
    iget-object v0, v0, Lcom/wishabi/flipp/widget/bi;->a:Landroid/graphics/RectF;

    iget v0, v0, Landroid/graphics/RectF;->right:F

    iget v5, v4, Landroid/graphics/RectF;->left:F

    cmpg-float v0, v0, v5

    if-gez v0, :cond_5

    .line 788
    :goto_2
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->p:Lcom/wishabi/flipp/widget/FlyerToolbar;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/FlyerToolbar;->setBackwardEnabled(Z)V

    goto :goto_0

    :cond_6
    move v1, v2

    goto :goto_2

    :cond_7
    move v0, v2

    goto :goto_1
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/FlyerCarouselFragment;I)V
    .locals 4

    .prologue
    .line 52
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->o:Landroid/view/View;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->d:[Landroid/os/Parcelable;

    aget-object v0, v0, p1

    check-cast v0, Lcom/wishabi/flipp/content/Flyer$Model;

    iget-object v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->o:Landroid/view/View;

    const v2, 0x7f0b0143

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iget-object v2, v0, Lcom/wishabi/flipp/content/Flyer$Model;->g:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iget-object v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->o:Landroid/view/View;

    const v2, 0x7f0b0144

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iget-object v2, v0, Lcom/wishabi/flipp/content/Flyer$Model;->l:Ljava/lang/String;

    iget-object v3, v0, Lcom/wishabi/flipp/content/Flyer$Model;->m:Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/wishabi/flipp/util/q;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iget-object v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->b:Lcom/wishabi/flipp/app/bn;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->b:Lcom/wishabi/flipp/app/bn;

    iget-object v2, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->o:Landroid/view/View;

    invoke-interface {v1, v2, v0}, Lcom/wishabi/flipp/app/bn;->a(Landroid/view/View;Lcom/wishabi/flipp/content/Flyer$Model;)V

    :cond_0
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/FlyerCarouselFragment;IZZ)V
    .locals 10

    .prologue
    const/4 v4, 0x0

    const/4 v9, 0x1

    const/4 v3, 0x0

    .line 52
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->z:Lcom/wishabi/flipp/app/bo;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->p:Lcom/wishabi/flipp/widget/FlyerToolbar;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->z:Lcom/wishabi/flipp/app/bo;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/bo;->getView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/FlyerViewGroup;

    if-eqz v0, :cond_0

    iput p1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->r:I

    iget v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->r:I

    if-nez v1, :cond_1

    iget-boolean v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->B:Z

    if-nez v1, :cond_1

    invoke-virtual {v0, v4}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->setHighlightAnnotations(Ljava/util/List;)V

    invoke-direct {p0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a()V

    invoke-direct {p0, v4}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a(Ljava/lang/String;)V

    :cond_0
    :goto_0
    return-void

    :cond_1
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    iget-object v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->z:Lcom/wishabi/flipp/app/bo;

    iget-object v1, v1, Lcom/wishabi/flipp/app/bo;->i:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    move v2, v3

    :cond_2
    :goto_1
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_4

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wishabi/flipp/widget/bi;

    iget v7, v1, Lcom/wishabi/flipp/widget/bi;->d:I

    if-nez v7, :cond_3

    iget v7, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->r:I

    if-lez v7, :cond_2

    iget v7, v1, Lcom/wishabi/flipp/widget/bi;->b:F

    iget v8, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->r:I

    int-to-float v8, v8

    cmpl-float v7, v7, v8

    if-ltz v7, :cond_2

    invoke-interface {v5, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v1, v2, 0x1

    move v2, v1

    goto :goto_1

    :cond_3
    if-ne v7, v9, :cond_2

    iget-boolean v7, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->B:Z

    if-eqz v7, :cond_2

    invoke-interface {v5, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    :cond_4
    invoke-virtual {v0, v5}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->setHighlightAnnotations(Ljava/util/List;)V

    invoke-direct {p0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a()V

    if-eqz p2, :cond_5

    if-lez v2, :cond_7

    const/4 v1, 0x6

    if-lt p1, v1, :cond_6

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v4, 0x7f0d0003

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v3

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v6, v9

    invoke-virtual {v1, v4, v2, v6}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    :goto_2
    invoke-direct {p0, v1}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a(Ljava/lang/String;)V

    :cond_5
    if-eqz p3, :cond_0

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getVisibleHighlightAnnotations()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_0

    invoke-interface {v5}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->l:Lcom/wishabi/flipp/widget/bh;

    invoke-interface {v0}, Lcom/wishabi/flipp/widget/bh;->a()V

    goto :goto_0

    :cond_6
    if-lez p1, :cond_b

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v4, 0x7f0d0002

    new-array v6, v9, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v3

    invoke-virtual {v1, v4, v2, v6}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto :goto_2

    :cond_7
    iget-boolean v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->g:Z

    if-eqz v1, :cond_8

    iget-object v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->z:Lcom/wishabi/flipp/app/bo;

    invoke-virtual {v1}, Lcom/wishabi/flipp/app/bo;->d()Z

    move-result v1

    if-eqz v1, :cond_8

    iget-object v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->z:Lcom/wishabi/flipp/app/bo;

    iget-boolean v1, v1, Lcom/wishabi/flipp/app/bo;->d:Z

    if-eqz v1, :cond_8

    const v1, 0x7f0e0102

    invoke-virtual {p0, v1}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_2

    :cond_8
    iget-boolean v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->g:Z

    if-eqz v1, :cond_9

    iget-object v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->z:Lcom/wishabi/flipp/app/bo;

    invoke-virtual {v1}, Lcom/wishabi/flipp/app/bo;->d()Z

    move-result v1

    if-nez v1, :cond_9

    const v1, 0x7f0e00f0

    invoke-virtual {p0, v1}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_2

    :cond_9
    iget-object v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->z:Lcom/wishabi/flipp/app/bo;

    invoke-virtual {v1}, Lcom/wishabi/flipp/app/bo;->d()Z

    move-result v1

    if-nez v1, :cond_a

    const v1, 0x7f0e00ef

    invoke-virtual {p0, v1}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_2

    :cond_a
    if-nez v2, :cond_b

    if-lez p1, :cond_b

    const v1, 0x7f0e00da

    new-array v2, v9, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {p0, v1, v2}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_2

    :cond_b
    move-object v1, v4

    goto/16 :goto_2
.end method

.method private a(Ljava/lang/String;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 792
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 793
    if-nez v1, :cond_1

    .line 823
    :cond_0
    :goto_0
    return-void

    .line 796
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->s:Landroid/widget/Toast;

    if-nez v0, :cond_2

    .line 797
    invoke-virtual {v1}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    const v2, 0x7f03002e

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 799
    if-eqz v0, :cond_0

    .line 802
    new-instance v2, Landroid/widget/Toast;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/widget/Toast;-><init>(Landroid/content/Context;)V

    iput-object v2, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->s:Landroid/widget/Toast;

    .line 803
    iget-object v2, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->s:Landroid/widget/Toast;

    invoke-virtual {v2, v0}, Landroid/widget/Toast;->setView(Landroid/view/View;)V

    .line 807
    :cond_2
    const/4 v2, 0x1

    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->q:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->isShown()Z

    move-result v0

    if-eqz v0, :cond_3

    const/high16 v0, 0x42c80000    # 100.0f

    :goto_1
    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    invoke-static {v2, v0, v1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    float-to-int v0, v0

    .line 811
    iget-object v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->s:Landroid/widget/Toast;

    const/16 v2, 0x50

    invoke-virtual {v1, v2, v4, v0}, Landroid/widget/Toast;->setGravity(III)V

    .line 813
    if-nez p1, :cond_4

    .line 814
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->s:Landroid/widget/Toast;

    invoke-virtual {v0}, Landroid/widget/Toast;->cancel()V

    goto :goto_0

    .line 807
    :cond_3
    const/high16 v0, 0x425c0000    # 55.0f

    goto :goto_1

    .line 818
    :cond_4
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->s:Landroid/widget/Toast;

    invoke-virtual {v0}, Landroid/widget/Toast;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0b00c2

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 820
    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 821
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->s:Landroid/widget/Toast;

    invoke-virtual {v0, v4}, Landroid/widget/Toast;->setDuration(I)V

    .line 822
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->s:Landroid/widget/Toast;

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Z
    .locals 1

    .prologue
    .line 52
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->B:Z

    return v0
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/FlyerCarouselFragment;Z)Z
    .locals 0

    .prologue
    .line 52
    iput-boolean p1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->B:Z

    return p1
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/FlyerCarouselFragment;I)I
    .locals 0

    .prologue
    .line 52
    iput p1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->f:I

    return p1
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/app/bo;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->z:Lcom/wishabi/flipp/app/bo;

    return-object v0
.end method

.method private b()V
    .locals 2

    .prologue
    .line 826
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->t:Landroid/view/Menu;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->y:Lcom/wishabi/flipp/content/Flyer$Model;

    if-nez v0, :cond_1

    .line 844
    :cond_0
    :goto_0
    return-void

    .line 829
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->u:Landroid/view/MenuItem;

    if-nez v0, :cond_2

    .line 830
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->t:Landroid/view/Menu;

    const v1, 0x7f0b015f

    invoke-interface {v0, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->u:Landroid/view/MenuItem;

    .line 832
    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->u:Landroid/view/MenuItem;

    if-eqz v0, :cond_3

    .line 833
    iget-object v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->u:Landroid/view/MenuItem;

    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->y:Lcom/wishabi/flipp/content/Flyer$Model;

    iget-boolean v0, v0, Lcom/wishabi/flipp/content/Flyer$Model;->p:Z

    if-eqz v0, :cond_5

    const v0, 0x7f0200cb

    :goto_1
    invoke-interface {v1, v0}, Landroid/view/MenuItem;->setIcon(I)Landroid/view/MenuItem;

    .line 837
    :cond_3
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->v:Landroid/view/MenuItem;

    if-nez v0, :cond_4

    .line 838
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->t:Landroid/view/Menu;

    const v1, 0x7f0b015e

    invoke-interface {v0, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->v:Landroid/view/MenuItem;

    .line 840
    :cond_4
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->v:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 841
    iget-object v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->v:Landroid/view/MenuItem;

    iget-boolean v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->x:Z

    if-eqz v0, :cond_6

    const v0, 0x7f0200d3

    :goto_2
    invoke-interface {v1, v0}, Landroid/view/MenuItem;->setIcon(I)Landroid/view/MenuItem;

    goto :goto_0

    .line 833
    :cond_5
    const v0, 0x7f0200ca

    goto :goto_1

    .line 841
    :cond_6
    const v0, 0x7f0200d2

    goto :goto_2
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/FlyerCarouselFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 52
    invoke-direct {p0, p1}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/FlyerCarouselFragment;Z)Z
    .locals 0

    .prologue
    .line 52
    iput-boolean p1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->g:Z

    return p1
.end method

.method static synthetic c(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)I
    .locals 1

    .prologue
    .line 52
    iget v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->r:I

    return v0
.end method

.method static synthetic c(Lcom/wishabi/flipp/app/FlyerCarouselFragment;Z)Z
    .locals 0

    .prologue
    .line 52
    iput-boolean p1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->D:Z

    return p1
.end method

.method static synthetic d(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/content/Flyer$Model;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->y:Lcom/wishabi/flipp/content/Flyer$Model;

    return-object v0
.end method

.method static synthetic d(Lcom/wishabi/flipp/app/FlyerCarouselFragment;Z)V
    .locals 12

    .prologue
    .line 52
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->D:Z

    if-eqz v0, :cond_2

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->isResumed()Z

    move-result v0

    if-eqz v0, :cond_2

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->D:Z

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    if-eqz v0, :cond_2

    const-string v1, "tap_to_hold_tutorial"

    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v2

    if-nez v2, :cond_3

    sget v1, Lcom/wishabi/flipp/app/fq;->c:I

    :goto_0
    sget v2, Lcom/wishabi/flipp/app/fq;->b:I

    if-ne v1, v2, :cond_0

    iput-boolean p1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->E:Z

    :cond_0
    sget v2, Lcom/wishabi/flipp/app/fq;->a:I

    if-ne v1, v2, :cond_1

    if-eqz p1, :cond_1

    invoke-static {v0}, Lcom/wishabi/flipp/app/fp;->a(Landroid/app/FragmentManager;)I

    move-result v1

    :cond_1
    sget v2, Lcom/wishabi/flipp/app/fq;->a:I

    if-ne v1, v2, :cond_2

    iget-object v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->d:[Landroid/os/Parcelable;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->d:[Landroid/os/Parcelable;

    array-length v1, v1

    const/4 v2, 0x1

    if-le v1, v2, :cond_2

    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v1

    if-nez v1, :cond_4

    sget v0, Lcom/wishabi/flipp/app/fq;->c:I

    :cond_2
    :goto_1
    return-void

    :cond_3
    new-instance v3, Lcom/wishabi/flipp/content/FormattedString;

    const/4 v4, 0x2

    new-array v4, v4, [Lcom/wishabi/flipp/content/FormattedString$Part;

    const/4 v5, 0x0

    new-instance v6, Lcom/wishabi/flipp/content/FormattedString$Part;

    const v7, 0x7f0e0153

    invoke-virtual {v2, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v7

    const/4 v8, 0x1

    new-array v8, v8, [Lcom/wishabi/flipp/content/FormattedString$Format;

    const/4 v9, 0x0

    new-instance v10, Lcom/wishabi/flipp/content/FormattedString$Format;

    sget v11, Lcom/wishabi/flipp/content/ab;->a:I

    invoke-direct {v10, v11}, Lcom/wishabi/flipp/content/FormattedString$Format;-><init>(I)V

    aput-object v10, v8, v9

    invoke-direct {v6, v7, v8}, Lcom/wishabi/flipp/content/FormattedString$Part;-><init>(Ljava/lang/String;[Lcom/wishabi/flipp/content/FormattedString$Format;)V

    aput-object v6, v4, v5

    const/4 v5, 0x1

    new-instance v6, Lcom/wishabi/flipp/content/FormattedString$Part;

    const v7, 0x7f0e0154

    invoke-virtual {v2, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/4 v7, 0x1

    new-array v7, v7, [Lcom/wishabi/flipp/content/FormattedString$Format;

    const/4 v8, 0x0

    new-instance v9, Lcom/wishabi/flipp/content/FormattedString$Format;

    sget v10, Lcom/wishabi/flipp/content/ab;->b:I

    invoke-direct {v9, v10}, Lcom/wishabi/flipp/content/FormattedString$Format;-><init>(I)V

    aput-object v9, v7, v8

    invoke-direct {v6, v2, v7}, Lcom/wishabi/flipp/content/FormattedString$Part;-><init>(Ljava/lang/String;[Lcom/wishabi/flipp/content/FormattedString$Format;)V

    aput-object v6, v4, v5

    invoke-direct {v3, v4}, Lcom/wishabi/flipp/content/FormattedString;-><init>([Lcom/wishabi/flipp/content/FormattedString$Part;)V

    const-string v2, "tutorial_showed_tap_to_clip"

    const v4, 0x7f0200fa

    const v5, 0x7f0200f8

    move-object v6, p0

    invoke-static/range {v0 .. v6}, Lcom/wishabi/flipp/app/fp;->a(Landroid/app/FragmentManager;Ljava/lang/String;Ljava/lang/String;Lcom/wishabi/flipp/content/FormattedString;IILcom/wishabi/flipp/app/dq;)I

    move-result v1

    goto :goto_0

    :cond_4
    new-instance v3, Lcom/wishabi/flipp/content/FormattedString;

    const/4 v2, 0x2

    new-array v2, v2, [Lcom/wishabi/flipp/content/FormattedString$Part;

    const/4 v4, 0x0

    new-instance v5, Lcom/wishabi/flipp/content/FormattedString$Part;

    const v6, 0x7f0e014c

    invoke-virtual {v1, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x1

    new-array v7, v7, [Lcom/wishabi/flipp/content/FormattedString$Format;

    const/4 v8, 0x0

    new-instance v9, Lcom/wishabi/flipp/content/FormattedString$Format;

    sget v10, Lcom/wishabi/flipp/content/ab;->a:I

    invoke-direct {v9, v10}, Lcom/wishabi/flipp/content/FormattedString$Format;-><init>(I)V

    aput-object v9, v7, v8

    invoke-direct {v5, v6, v7}, Lcom/wishabi/flipp/content/FormattedString$Part;-><init>(Ljava/lang/String;[Lcom/wishabi/flipp/content/FormattedString$Format;)V

    aput-object v5, v2, v4

    const/4 v4, 0x1

    new-instance v5, Lcom/wishabi/flipp/content/FormattedString$Part;

    const v6, 0x7f0e014d

    invoke-virtual {v1, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v6, 0x1

    new-array v6, v6, [Lcom/wishabi/flipp/content/FormattedString$Format;

    const/4 v7, 0x0

    new-instance v8, Lcom/wishabi/flipp/content/FormattedString$Format;

    sget v9, Lcom/wishabi/flipp/content/ab;->b:I

    invoke-direct {v8, v9}, Lcom/wishabi/flipp/content/FormattedString$Format;-><init>(I)V

    aput-object v8, v6, v7

    invoke-direct {v5, v1, v6}, Lcom/wishabi/flipp/content/FormattedString$Part;-><init>(Ljava/lang/String;[Lcom/wishabi/flipp/content/FormattedString$Format;)V

    aput-object v5, v2, v4

    invoke-direct {v3, v2}, Lcom/wishabi/flipp/content/FormattedString;-><init>([Lcom/wishabi/flipp/content/FormattedString$Part;)V

    const/4 v1, 0x0

    const-string v2, "tutorial_showed_cross_browse"

    const v4, 0x7f0200f6

    const v5, 0x7f0200f8

    const/4 v6, 0x0

    invoke-static/range {v0 .. v6}, Lcom/wishabi/flipp/app/fp;->a(Landroid/app/FragmentManager;Ljava/lang/String;Ljava/lang/String;Lcom/wishabi/flipp/content/FormattedString;IILcom/wishabi/flipp/app/dq;)I

    goto/16 :goto_1
.end method

.method static synthetic e(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)[Landroid/os/Parcelable;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->d:[Landroid/os/Parcelable;

    return-object v0
.end method

.method static synthetic f(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lfr/castorflex/android/verticalviewpager/VerticalViewPager;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->e:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    return-object v0
.end method

.method static synthetic g(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)V
    .locals 0

    .prologue
    .line 52
    invoke-direct {p0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->b()V

    return-void
.end method

.method static synthetic h(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Z
    .locals 1

    .prologue
    .line 52
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->n:Z

    return v0
.end method

.method static synthetic i(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Z
    .locals 1

    .prologue
    .line 52
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->n:Z

    return v0
.end method

.method static synthetic j(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Z
    .locals 1

    .prologue
    .line 52
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->w:Z

    return v0
.end method

.method static synthetic k(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Z
    .locals 1

    .prologue
    .line 52
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->w:Z

    return v0
.end method

.method static synthetic l(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->h:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic m(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Z
    .locals 1

    .prologue
    .line 52
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->C:Z

    return v0
.end method

.method static synthetic n(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Z
    .locals 1

    .prologue
    .line 52
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->C:Z

    return v0
.end method

.method static synthetic o(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/widget/FlyerToolbar;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->p:Lcom/wishabi/flipp/widget/FlyerToolbar;

    return-object v0
.end method

.method static synthetic p(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->c:Landroid/os/Bundle;

    return-object v0
.end method

.method static synthetic q(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)I
    .locals 1

    .prologue
    .line 52
    iget v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->j:I

    return v0
.end method

.method static synthetic r(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/widget/ShoppingListPopup;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->q:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    return-object v0
.end method

.method static synthetic s(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)V
    .locals 0

    .prologue
    .line 52
    invoke-direct {p0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a()V

    return-void
.end method

.method static synthetic t(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/widget/bh;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->l:Lcom/wishabi/flipp/widget/bh;

    return-object v0
.end method

.method static synthetic u(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Z
    .locals 1

    .prologue
    .line 52
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->A:Z

    return v0
.end method


# virtual methods
.method public final a(Lcom/wishabi/flipp/app/dp;)V
    .locals 2

    .prologue
    .line 686
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    .line 687
    if-nez v0, :cond_1

    .line 700
    :cond_0
    :goto_0
    return-void

    .line 690
    :cond_1
    invoke-virtual {p1}, Lcom/wishabi/flipp/app/dp;->getTag()Ljava/lang/String;

    move-result-object v0

    .line 691
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 694
    const-string v1, "tap_to_hold_tutorial"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->isResumed()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 695
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->E:Z

    if-eqz v0, :cond_2

    .line 696
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    invoke-static {v0}, Lcom/wishabi/flipp/app/fp;->a(Landroid/app/FragmentManager;)I

    .line 698
    :cond_2
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->E:Z

    goto :goto_0
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/content/Loader;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 610
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 611
    if-nez v1, :cond_0

    .line 620
    :goto_0
    return-object v3

    .line 614
    :cond_0
    packed-switch p1, :pswitch_data_0

    goto :goto_0

    .line 616
    :pswitch_0
    new-instance v0, Landroid/content/CursorLoader;

    sget-object v2, Lcom/wishabi/flipp/content/i;->f:Landroid/net/Uri;

    const-string v4, "_id = ?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    iget v7, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->f:I

    invoke-static {v7}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    move-object v6, v3

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    move-object v3, v0

    goto :goto_0

    .line 614
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 553
    invoke-super {p0, p1, p2}, Landroid/app/Fragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 554
    const v0, 0x7f100006

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 555
    iput-object p1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->t:Landroid/view/Menu;

    .line 556
    iput-object v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->v:Landroid/view/MenuItem;

    .line 557
    iput-object v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->u:Landroid/view/MenuItem;

    .line 559
    invoke-direct {p0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->b()V

    .line 560
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 8

    .prologue
    const/4 v7, -0x1

    const/4 v1, 0x1

    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 354
    const v0, 0x7f030027

    invoke-virtual {p1, v0, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v4

    .line 356
    if-nez v4, :cond_0

    move-object v0, v3

    .line 528
    :goto_0
    return-object v0

    .line 358
    :cond_0
    invoke-virtual {p0, v1}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->setHasOptionsMenu(Z)V

    .line 359
    iput-boolean v2, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->n:Z

    .line 361
    const v0, 0x7f030053

    invoke-virtual {p1, v0, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->o:Landroid/view/View;

    .line 362
    const v0, 0x7f0b00ab

    invoke-virtual {v4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    iput-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->e:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    .line 364
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->e:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    if-nez v0, :cond_1

    move-object v0, v3

    .line 365
    goto :goto_0

    .line 367
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->e:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    iget-object v5, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a:Landroid/support/v4/view/ch;

    invoke-virtual {v0, v5}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->setOnPageChangeListener(Landroid/support/v4/view/cd;)V

    .line 368
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->e:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    new-instance v5, Lcom/wishabi/flipp/app/bi;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v6

    invoke-direct {v5, p0, v6}, Lcom/wishabi/flipp/app/bi;-><init>(Lcom/wishabi/flipp/app/FlyerCarouselFragment;Landroid/app/FragmentManager;)V

    invoke-virtual {v0, v5}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->setAdapter(Landroid/support/v4/view/ae;)V

    .line 482
    const v0, 0x7f0b00ac

    invoke-virtual {v4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/FlyerToolbar;

    iput-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->p:Lcom/wishabi/flipp/widget/FlyerToolbar;

    .line 483
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->p:Lcom/wishabi/flipp/widget/FlyerToolbar;

    if-nez v0, :cond_2

    move-object v0, v3

    .line 484
    goto :goto_0

    .line 486
    :cond_2
    invoke-direct {p0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a()V

    .line 487
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->p:Lcom/wishabi/flipp/widget/FlyerToolbar;

    iget-object v5, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->l:Lcom/wishabi/flipp/widget/bh;

    invoke-virtual {v0, v5}, Lcom/wishabi/flipp/widget/FlyerToolbar;->setFlyerToolbarListener(Lcom/wishabi/flipp/widget/bh;)V

    .line 489
    const v0, 0x7f0b00ad

    invoke-virtual {v4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ShoppingListPopup;

    iput-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->q:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    .line 491
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->q:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    if-nez v0, :cond_3

    move-object v0, v3

    .line 492
    goto :goto_0

    .line 494
    :cond_3
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->q:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    iget-object v3, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->m:Lcom/wishabi/flipp/widget/dr;

    invoke-virtual {v0, v3}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->setShoppingListPopupListener(Lcom/wishabi/flipp/widget/dr;)V

    .line 496
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->q:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->a(Z)V

    .line 499
    sget v0, Lcom/wishabi/flipp/app/bm;->a:I

    iput v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->j:I

    .line 501
    if-nez p3, :cond_4

    .line 502
    iput-boolean v2, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->B:Z

    .line 503
    iput-boolean v2, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->C:Z

    .line 526
    :goto_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->p:Lcom/wishabi/flipp/widget/FlyerToolbar;

    iget-boolean v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->B:Z

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/FlyerToolbar;->setShowCoupon(Z)V

    move-object v0, v4

    .line 528
    goto :goto_0

    .line 505
    :cond_4
    const-string v0, "SAVE_STATE_DISCOUNT_KEY"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->r:I

    .line 506
    iput-boolean v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->w:Z

    .line 507
    const-string v0, "SAVE_STATE_CROSS_BROWSE_KEY"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->n:Z

    .line 509
    const-string v0, "SAVE_STATE_CAROUSEL_POSITION_KEY"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->i:Ljava/lang/Integer;

    .line 512
    const-string v0, "flyer_mode"

    invoke-virtual {p3, v0, v7}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 513
    if-eq v0, v7, :cond_5

    .line 514
    invoke-static {}, Lcom/wishabi/flipp/app/bm;->a()[I

    move-result-object v3

    aget v0, v3, v0

    iput v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->j:I

    .line 516
    :cond_5
    const-string v0, "SAVE_STATE_HIGHLIGHT_COUPON_KEY"

    invoke-virtual {p3, v0, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->B:Z

    .line 519
    const-string v0, "SAVE_STATE_SHOW_TUTORIAL_KEY"

    invoke-virtual {p3, v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-nez v0, :cond_6

    move v0, v1

    :goto_2
    iput-boolean v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->C:Z

    .line 522
    const-string v0, "SAVE_STATE_SHOW_COUPON_TUTORIAL_ON_DISMISS_KEY"

    invoke-virtual {p3, v0, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->E:Z

    goto :goto_1

    :cond_6
    move v0, v2

    .line 519
    goto :goto_2
.end method

.method public synthetic onLoadFinished(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 1

    .prologue
    .line 52
    check-cast p2, Landroid/database/Cursor;

    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    :goto_0
    return-void

    :pswitch_0
    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_1
    iput-boolean v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->x:Z

    invoke-direct {p0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->b()V

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method public onLoaderReset(Landroid/content/Loader;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 636
    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 642
    :goto_0
    return-void

    .line 638
    :pswitch_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->x:Z

    .line 639
    invoke-direct {p0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->b()V

    goto :goto_0

    .line 636
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 9

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 564
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    .line 565
    if-nez v3, :cond_1

    .line 566
    invoke-super {p0, p1}, Landroid/app/Fragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v1

    .line 605
    :cond_0
    :goto_0
    return v1

    .line 568
    :cond_1
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const v4, 0x7f0b015f

    if-ne v0, v4, :cond_4

    iget-boolean v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->A:Z

    if-nez v0, :cond_4

    .line 569
    iput-boolean v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->A:Z

    .line 571
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->z:Lcom/wishabi/flipp/app/bo;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->z:Lcom/wishabi/flipp/app/bo;

    iget-boolean v0, v0, Lcom/wishabi/flipp/app/bo;->d:Z

    if-eqz v0, :cond_2

    move v0, v1

    .line 574
    :goto_1
    iget-object v2, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->y:Lcom/wishabi/flipp/content/Flyer$Model;

    iget v2, v2, Lcom/wishabi/flipp/content/Flyer$Model;->a:I

    iget-object v4, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->y:Lcom/wishabi/flipp/content/Flyer$Model;

    iget-object v4, v4, Lcom/wishabi/flipp/content/Flyer$Model;->g:Ljava/lang/String;

    iget-boolean v5, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->g:Z

    new-instance v6, Lcom/wishabi/flipp/app/bl;

    invoke-direct {v6, p0}, Lcom/wishabi/flipp/app/bl;-><init>(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)V

    if-eqz v3, :cond_0

    invoke-virtual {v3}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    invoke-virtual {v7}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v7

    const/4 v8, 0x3

    invoke-virtual {v7, v8}, Landroid/content/res/Configuration;->isLayoutSizeAtLeast(I)Z

    move-result v7

    if-eqz v7, :cond_3

    sget v7, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v8, 0x11

    if-lt v7, v8, :cond_3

    invoke-static {v2, v4, v5, v0}, Lcom/wishabi/flipp/app/cd;->a(ILjava/lang/String;ZZ)Lcom/wishabi/flipp/app/cd;

    move-result-object v0

    iput-object v6, v0, Lcom/wishabi/flipp/app/dp;->a:Lcom/wishabi/flipp/app/dq;

    invoke-virtual {v3}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    const-string v3, "info_pop"

    invoke-virtual {v0, v2, v3}, Lcom/wishabi/flipp/app/cd;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    sget v0, Lcom/wishabi/flipp/app/ds;->b:I

    goto :goto_0

    :cond_2
    move v0, v2

    .line 571
    goto :goto_1

    .line 574
    :cond_3
    invoke-static {v2, v4, v5, v0}, Lcom/wishabi/flipp/app/FlyerInfoActivity;->a(ILjava/lang/String;ZZ)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v3, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    const v0, 0x7f040001

    const v2, 0x7f040002

    invoke-virtual {v3, v0, v2}, Landroid/app/Activity;->overridePendingTransition(II)V

    sget v0, Lcom/wishabi/flipp/app/ds;->a:I

    goto :goto_0

    .line 584
    :cond_4
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const v4, 0x7f0b015e

    if-ne v0, v4, :cond_6

    .line 585
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->x:Z

    if-nez v0, :cond_5

    .line 586
    const v0, 0x7f0e0005

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a(Ljava/lang/String;)V

    .line 587
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 588
    const-string v2, "_id"

    iget v4, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->f:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v0, v2, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 589
    invoke-virtual {v3}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    sget-object v3, Lcom/wishabi/flipp/content/i;->f:Landroid/net/Uri;

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    .line 592
    sget-object v2, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->d:[Landroid/os/Parcelable;

    iget-object v3, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->e:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    invoke-virtual {v3}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->getCurrentItem()I

    move-result v3

    aget-object v0, v0, v3

    check-cast v0, Lcom/wishabi/flipp/content/Flyer$Model;

    invoke-virtual {v2, v0, v1}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/Flyer$Model;Z)V

    goto/16 :goto_0

    .line 595
    :cond_5
    const v0, 0x7f0e0114

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a(Ljava/lang/String;)V

    .line 596
    invoke-virtual {v3}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v3, Lcom/wishabi/flipp/content/i;->f:Landroid/net/Uri;

    const-string v4, "_id = ?"

    new-array v5, v1, [Ljava/lang/String;

    iget v6, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->f:I

    invoke-static {v6}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v2

    invoke-virtual {v0, v3, v4, v5}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 599
    sget-object v3, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->d:[Landroid/os/Parcelable;

    iget-object v4, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->e:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    invoke-virtual {v4}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->getCurrentItem()I

    move-result v4

    aget-object v0, v0, v4

    check-cast v0, Lcom/wishabi/flipp/content/Flyer$Model;

    invoke-virtual {v3, v0, v2}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/Flyer$Model;Z)V

    goto/16 :goto_0

    .line 605
    :cond_6
    invoke-super {p0, p1}, Landroid/app/Fragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v1

    goto/16 :goto_0
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 668
    invoke-super {p0}, Landroid/app/Fragment;->onPause()V

    .line 669
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    invoke-virtual {v0}, Lcom/wishabi/flipp/b/a;->a()V

    .line 670
    return-void
.end method

.method public onResume()V
    .locals 3

    .prologue
    .line 674
    invoke-super {p0}, Landroid/app/Fragment;->onResume()V

    .line 675
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->A:Z

    .line 677
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->z:Lcom/wishabi/flipp/app/bo;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->y:Lcom/wishabi/flipp/content/Flyer$Model;

    if-nez v0, :cond_1

    .line 682
    :cond_0
    :goto_0
    return-void

    .line 680
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->l:Lcom/wishabi/flipp/widget/bh;

    iget-object v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->p:Lcom/wishabi/flipp/widget/FlyerToolbar;

    iget v2, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->r:I

    invoke-interface {v0, v1, v2}, Lcom/wishabi/flipp/widget/bh;->a(Lcom/wishabi/flipp/widget/FlyerToolbar;I)V

    goto :goto_0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 646
    invoke-super {p0, p1}, Landroid/app/Fragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 647
    const-string v0, "SAVE_STATE_DISCOUNT_KEY"

    iget v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->r:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 648
    const-string v0, "SAVE_STATE_CROSS_BROWSE_KEY"

    sget-object v1, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-boolean v1, v1, Lcom/wishabi/flipp/b/a;->r:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 651
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->e:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    if-eqz v0, :cond_0

    .line 652
    const-string v0, "SAVE_STATE_CAROUSEL_POSITION_KEY"

    iget-object v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->e:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    invoke-virtual {v1}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->getCurrentItem()I

    move-result v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 655
    :cond_0
    const-string v0, "flyer_mode"

    iget v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->j:I

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 657
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->p:Lcom/wishabi/flipp/widget/FlyerToolbar;

    if-eqz v0, :cond_1

    .line 658
    const-string v0, "SAVE_STATE_HIGHLIGHT_COUPON_KEY"

    iget-object v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->p:Lcom/wishabi/flipp/widget/FlyerToolbar;

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/FlyerToolbar;->getShowCoupon()Z

    move-result v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 661
    :cond_1
    const-string v0, "SAVE_STATE_SHOW_TUTORIAL_KEY"

    iget-boolean v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->D:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 662
    const-string v0, "SAVE_STATE_SHOW_COUPON_TUTORIAL_ON_DISMISS_KEY"

    iget-boolean v1, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->E:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 664
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 533
    invoke-super {p0, p1, p2}, Landroid/app/Fragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 536
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->E:Z

    if-eqz v0, :cond_0

    .line 537
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    .line 538
    if-nez v0, :cond_1

    .line 549
    :cond_0
    :goto_0
    return-void

    .line 541
    :cond_1
    const-string v1, "tap_to_hold_tutorial"

    invoke-virtual {v0, v1}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/fn;

    .line 544
    if-eqz v0, :cond_0

    .line 547
    iput-object p0, v0, Lcom/wishabi/flipp/app/dp;->a:Lcom/wishabi/flipp/app/dq;

    goto :goto_0
.end method
