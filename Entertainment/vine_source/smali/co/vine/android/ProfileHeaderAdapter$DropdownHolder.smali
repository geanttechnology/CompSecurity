.class public Lco/vine/android/ProfileHeaderAdapter$DropdownHolder;
.super Ljava/lang/Object;
.source "ProfileHeaderAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/ProfileHeaderAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DropdownHolder"
.end annotation


# instance fields
.field public final revineIcon:Landroid/widget/ImageView;

.field public final revineLabel:Landroid/widget/TextView;

.field public final revineParent:Landroid/view/View;


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 644
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 645
    const v0, 0x7f0a0197

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/ProfileHeaderAdapter$DropdownHolder;->revineParent:Landroid/view/View;

    .line 646
    const v0, 0x7f0a0198

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lco/vine/android/ProfileHeaderAdapter$DropdownHolder;->revineLabel:Landroid/widget/TextView;

    .line 647
    const v0, 0x7f0a0199

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lco/vine/android/ProfileHeaderAdapter$DropdownHolder;->revineIcon:Landroid/widget/ImageView;

    .line 648
    return-void
.end method
