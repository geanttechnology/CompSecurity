.class public Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;
.super Landroid/widget/ListView;
.source "TwisterListView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$1;,
        Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter;
    }
.end annotation


# instance fields
.field private dialog:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;

.field protected editions:[Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;

.field userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 51
    invoke-direct {p0, p1, p2}, Landroid/widget/ListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 52
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 53
    new-instance v0, Landroid/graphics/drawable/ColorDrawable;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/retailsearch/R$color;->rs_twister_divider:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-direct {v0, v1}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;->setDivider(Landroid/graphics/drawable/Drawable;)V

    .line 54
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;->setDividerHeight(I)V

    .line 55
    const/4 v0, 0x2

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;->setOverScrollMode(I)V

    .line 56
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter;-><init>(Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$1;)V

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 57
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;)Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;->dialog:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;

    return-object v0
.end method


# virtual methods
.method public getEditions()[Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;->editions:[Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;

    return-object v0
.end method

.method public setEditions([Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;)V
    .locals 0
    .param p1, "editions"    # [Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;->editions:[Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;

    .line 66
    return-void
.end method

.method protected setTwisterDialog(Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;)V
    .locals 0
    .param p1, "dialog"    # Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;

    .prologue
    .line 83
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;->dialog:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;

    .line 84
    return-void
.end method
