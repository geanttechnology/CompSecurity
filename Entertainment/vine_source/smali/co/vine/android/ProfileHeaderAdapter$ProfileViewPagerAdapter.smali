.class Lco/vine/android/ProfileHeaderAdapter$ProfileViewPagerAdapter;
.super Landroid/support/v4/view/PagerAdapter;
.source "ProfileHeaderAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/ProfileHeaderAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ProfileViewPagerAdapter"
.end annotation


# static fields
.field public static final PAGER_COUNT:I = 0x2

.field public static final PAGER_INDEX_DETAILS:I = 0x1

.field public static final PAGER_INDEX_MAIN:I


# instance fields
.field final synthetic this$0:Lco/vine/android/ProfileHeaderAdapter;


# direct methods
.method private constructor <init>(Lco/vine/android/ProfileHeaderAdapter;)V
    .locals 0

    .prologue
    .line 512
    iput-object p1, p0, Lco/vine/android/ProfileHeaderAdapter$ProfileViewPagerAdapter;->this$0:Lco/vine/android/ProfileHeaderAdapter;

    invoke-direct {p0}, Landroid/support/v4/view/PagerAdapter;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lco/vine/android/ProfileHeaderAdapter;Lco/vine/android/ProfileHeaderAdapter$1;)V
    .locals 0
    .param p1, "x0"    # Lco/vine/android/ProfileHeaderAdapter;
    .param p2, "x1"    # Lco/vine/android/ProfileHeaderAdapter$1;

    .prologue
    .line 512
    invoke-direct {p0, p1}, Lco/vine/android/ProfileHeaderAdapter$ProfileViewPagerAdapter;-><init>(Lco/vine/android/ProfileHeaderAdapter;)V

    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 520
    const/4 v0, 0x2

    return v0
.end method

.method public instantiateItem(Landroid/view/ViewGroup;I)Ljava/lang/Object;
    .locals 5
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "position"    # I

    .prologue
    const/4 v4, 0x0

    .line 525
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, "layout_inflater"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    .line 527
    .local v0, "inflater":Landroid/view/LayoutInflater;
    packed-switch p2, :pswitch_data_0

    .line 549
    const/4 v1, 0x0

    :cond_0
    :goto_0
    return-object v1

    .line 529
    :pswitch_0
    const v2, 0x7f030078

    invoke-virtual {v0, v2, p1, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 530
    .local v1, "v":Landroid/view/View;
    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter$ProfileViewPagerAdapter;->this$0:Lco/vine/android/ProfileHeaderAdapter;

    new-instance v3, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;

    invoke-direct {v3, v1}, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;-><init>(Landroid/view/View;)V

    # setter for: Lco/vine/android/ProfileHeaderAdapter;->mHolderPagerMain:Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;
    invoke-static {v2, v3}, Lco/vine/android/ProfileHeaderAdapter;->access$102(Lco/vine/android/ProfileHeaderAdapter;Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;)Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;

    .line 531
    invoke-virtual {p1, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 532
    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter$ProfileViewPagerAdapter;->this$0:Lco/vine/android/ProfileHeaderAdapter;

    # getter for: Lco/vine/android/ProfileHeaderAdapter;->mUser:Lco/vine/android/api/VineUser;
    invoke-static {v2}, Lco/vine/android/ProfileHeaderAdapter;->access$200(Lco/vine/android/ProfileHeaderAdapter;)Lco/vine/android/api/VineUser;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 533
    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter$ProfileViewPagerAdapter;->this$0:Lco/vine/android/ProfileHeaderAdapter;

    iget-object v3, p0, Lco/vine/android/ProfileHeaderAdapter$ProfileViewPagerAdapter;->this$0:Lco/vine/android/ProfileHeaderAdapter;

    # getter for: Lco/vine/android/ProfileHeaderAdapter;->mUser:Lco/vine/android/api/VineUser;
    invoke-static {v3}, Lco/vine/android/ProfileHeaderAdapter;->access$200(Lco/vine/android/ProfileHeaderAdapter;)Lco/vine/android/api/VineUser;

    move-result-object v3

    invoke-virtual {v2, v3}, Lco/vine/android/ProfileHeaderAdapter;->bindUser(Lco/vine/android/api/VineUser;)V

    goto :goto_0

    .line 538
    .end local v1    # "v":Landroid/view/View;
    :pswitch_1
    const v2, 0x7f030077

    invoke-virtual {v0, v2, p1, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 539
    .restart local v1    # "v":Landroid/view/View;
    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter$ProfileViewPagerAdapter;->this$0:Lco/vine/android/ProfileHeaderAdapter;

    new-instance v3, Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;

    invoke-direct {v3, v1}, Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;-><init>(Landroid/view/View;)V

    # setter for: Lco/vine/android/ProfileHeaderAdapter;->mHolderPagerDetails:Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;
    invoke-static {v2, v3}, Lco/vine/android/ProfileHeaderAdapter;->access$302(Lco/vine/android/ProfileHeaderAdapter;Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;)Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;

    .line 540
    invoke-virtual {p1, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 541
    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter$ProfileViewPagerAdapter;->this$0:Lco/vine/android/ProfileHeaderAdapter;

    # getter for: Lco/vine/android/ProfileHeaderAdapter;->mUser:Lco/vine/android/api/VineUser;
    invoke-static {v2}, Lco/vine/android/ProfileHeaderAdapter;->access$200(Lco/vine/android/ProfileHeaderAdapter;)Lco/vine/android/api/VineUser;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 542
    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter$ProfileViewPagerAdapter;->this$0:Lco/vine/android/ProfileHeaderAdapter;

    iget-object v3, p0, Lco/vine/android/ProfileHeaderAdapter$ProfileViewPagerAdapter;->this$0:Lco/vine/android/ProfileHeaderAdapter;

    # getter for: Lco/vine/android/ProfileHeaderAdapter;->mUser:Lco/vine/android/api/VineUser;
    invoke-static {v3}, Lco/vine/android/ProfileHeaderAdapter;->access$200(Lco/vine/android/ProfileHeaderAdapter;)Lco/vine/android/api/VineUser;

    move-result-object v3

    invoke-virtual {v2, v3}, Lco/vine/android/ProfileHeaderAdapter;->bindUser(Lco/vine/android/api/VineUser;)V

    .line 545
    :cond_1
    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter$ProfileViewPagerAdapter;->this$0:Lco/vine/android/ProfileHeaderAdapter;

    # invokes: Lco/vine/android/ProfileHeaderAdapter;->invalidateDetailHeight()V
    invoke-static {v2}, Lco/vine/android/ProfileHeaderAdapter;->access$400(Lco/vine/android/ProfileHeaderAdapter;)V

    goto :goto_0

    .line 527
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public isViewFromObject(Landroid/view/View;Ljava/lang/Object;)Z
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "o"    # Ljava/lang/Object;

    .prologue
    .line 554
    if-ne p1, p2, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
