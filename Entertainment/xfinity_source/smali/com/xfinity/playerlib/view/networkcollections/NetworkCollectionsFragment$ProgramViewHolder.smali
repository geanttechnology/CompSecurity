.class Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;
.super Ljava/lang/Object;
.source "NetworkCollectionsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ProgramViewHolder"
.end annotation


# instance fields
.field public carousel:Lit/sephiroth/android/library/widget/HListView;

.field public coverArt:Landroid/widget/ImageView;

.field public downloadIndicator:Landroid/widget/ImageView;

.field public lockedIndicator:Landroid/view/View;

.field public networkLogo:Landroid/widget/ImageView;

.field public placeholderTitle:Landroid/widget/TextView;

.field public title:Landroid/widget/TextView;

.field public year:Landroid/widget/TextView;


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 409
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$1;

    .prologue
    .line 409
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;-><init>()V

    return-void
.end method
