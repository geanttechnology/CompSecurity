.class Lcom/poshmark/ui/fragments/FeedMotherFragment$ScreenSlidePagerAdapter;
.super Lcom/poshmark/utils/FragmentPagerAdapter;
.source "FeedMotherFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/FeedMotherFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ScreenSlidePagerAdapter"
.end annotation


# static fields
.field private static final NUM_PAGES:I = 0x3


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;


# direct methods
.method public constructor <init>(Lcom/poshmark/ui/fragments/FeedMotherFragment;Landroid/support/v4/app/FragmentManager;)V
    .locals 0
    .param p2, "fm"    # Landroid/support/v4/app/FragmentManager;

    .prologue
    .line 263
    iput-object p1, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$ScreenSlidePagerAdapter;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    .line 264
    invoke-direct {p0, p2}, Lcom/poshmark/utils/FragmentPagerAdapter;-><init>(Landroid/support/v4/app/FragmentManager;)V

    .line 265
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 289
    const/4 v0, 0x3

    return v0
.end method

.method public getCurrentVisibleFragment()Landroid/support/v4/app/Fragment;
    .locals 1

    .prologue
    .line 293
    invoke-super {p0}, Lcom/poshmark/utils/FragmentPagerAdapter;->getCurrentVisibleFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    return-object v0
.end method

.method public getItem(I)Landroid/support/v4/app/Fragment;
    .locals 4
    .param p1, "position"    # I

    .prologue
    const/4 v3, 0x0

    .line 269
    packed-switch p1, :pswitch_data_0

    .line 283
    const/4 v0, 0x0

    :goto_0
    return-object v0

    .line 271
    :pswitch_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$ScreenSlidePagerAdapter;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$ScreenSlidePagerAdapter;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const-class v2, Lcom/poshmark/ui/fragments/MyLikesFragment;

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/support/v4/app/Fragment;->instantiate(Landroid/content/Context;Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/PMFragment;

    iput-object v0, v1, Lcom/poshmark/ui/fragments/FeedMotherFragment;->myLikesFragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 272
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$ScreenSlidePagerAdapter;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->myLikesFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v0, v3}, Lcom/poshmark/ui/fragments/PMFragment;->setUserVisibleHint(Z)V

    .line 273
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$ScreenSlidePagerAdapter;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->myLikesFragment:Lcom/poshmark/ui/fragments/PMFragment;

    goto :goto_0

    .line 275
    :pswitch_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$ScreenSlidePagerAdapter;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$ScreenSlidePagerAdapter;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const-class v2, Lcom/poshmark/ui/fragments/FeedFragment;

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/support/v4/app/Fragment;->instantiate(Landroid/content/Context;Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/PMFragment;

    iput-object v0, v1, Lcom/poshmark/ui/fragments/FeedMotherFragment;->feedFragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 276
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$ScreenSlidePagerAdapter;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->feedFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v0, v3}, Lcom/poshmark/ui/fragments/PMFragment;->setUserVisibleHint(Z)V

    .line 277
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$ScreenSlidePagerAdapter;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->feedFragment:Lcom/poshmark/ui/fragments/PMFragment;

    goto :goto_0

    .line 279
    :pswitch_2
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$ScreenSlidePagerAdapter;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$ScreenSlidePagerAdapter;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const-class v2, Lcom/poshmark/ui/fragments/FindPeopleFragment;

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/support/v4/app/Fragment;->instantiate(Landroid/content/Context;Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/PMFragment;

    iput-object v0, v1, Lcom/poshmark/ui/fragments/FeedMotherFragment;->peopleFragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 280
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$ScreenSlidePagerAdapter;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->peopleFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v0, v3}, Lcom/poshmark/ui/fragments/PMFragment;->setUserVisibleHint(Z)V

    .line 281
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$ScreenSlidePagerAdapter;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->peopleFragment:Lcom/poshmark/ui/fragments/PMFragment;

    goto :goto_0

    .line 269
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
