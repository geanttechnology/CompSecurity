.class Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;
.super Ljava/lang/Object;
.source "ProfileHeaderAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/ProfileHeaderAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "PagerMainViewHolder"
.end annotation


# instance fields
.field public final followers:Lco/vine/android/widget/TypefacesTextView;

.field public final following:Lco/vine/android/widget/TypefacesTextView;

.field public imageAction:Landroid/widget/ImageView;

.field public imageFrame:Landroid/widget/ImageView;

.field public imageView:Landroid/widget/ImageView;

.field public userImageKey:Lco/vine/android/util/image/ImageKey;

.field public username:Landroid/widget/TextView;

.field public verified:Landroid/widget/ImageView;


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 571
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 572
    const v0, 0x7f0a022a

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->imageFrame:Landroid/widget/ImageView;

    .line 573
    const v0, 0x7f0a00c4

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->username:Landroid/widget/TextView;

    .line 574
    const v0, 0x7f0a01a2

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->verified:Landroid/widget/ImageView;

    .line 575
    const v0, 0x7f0a0063

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->imageView:Landroid/widget/ImageView;

    .line 576
    const v0, 0x7f0a022b

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->imageAction:Landroid/widget/ImageView;

    .line 577
    const v0, 0x7f0a01a3

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lco/vine/android/widget/TypefacesTextView;

    iput-object v0, p0, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->followers:Lco/vine/android/widget/TypefacesTextView;

    .line 578
    const v0, 0x7f0a01a4

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lco/vine/android/widget/TypefacesTextView;

    iput-object v0, p0, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->following:Lco/vine/android/widget/TypefacesTextView;

    .line 579
    return-void
.end method
