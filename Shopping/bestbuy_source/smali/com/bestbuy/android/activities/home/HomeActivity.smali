.class public Lcom/bestbuy/android/activities/home/HomeActivity;
.super Lcom/bestbuy/android/base/BBYBaseFragmentActivity;
.source "SourceFile"

# interfaces
.implements Lahx;
.implements Landroid/view/View$OnClickListener;
.implements Lbw;
.implements Lcl;
.implements Lct;
.implements Lcu;
.implements Lcv;
.implements Ldp;
.implements Lqo;
.implements Lqp;


# static fields
.field public static final CHAT_STATUS:Ljava/lang/String; = "chatstatus"

.field private static final EXITAPP_DELAY:I = 0xbb8

.field private static final TAG:Ljava/lang/String;

.field private static backpress:J

.field public static inDNMFragment:Z

.field public static inLifeEventsFragment:Z

.field public static inListIdSearchFragment:Z

.field public static inPDPFragment:Z

.field public static inStoresFragment:Z

.field public static inWrapperFragment:Z

.field private static productShareURL:Ljava/lang/String;


# instance fields
.field private actionBarTitle:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private actionIconClickListener:Lcf;

.field private activateBanner:Landroid/widget/RelativeLayout;

.field private addToItem:Landroid/view/MenuItem;

.field private addToItemLayout:Landroid/widget/LinearLayout;

.field private appData:Lnb;

.field private bbyProduct:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

.field private breadCrumb:Ljava/lang/String;

.field private chatMessageReceiver:Landroid/content/BroadcastReceiver;

.field private clearReviewsClickListener:Lcj;

.field private clearReviewsItem:Landroid/view/MenuItem;

.field private clearReviewsLayout:Landroid/widget/LinearLayout;

.field private geoLocateItem:Landroid/view/MenuItem;

.field private hasOptionsMenu:Z

.field private homeTabFragment:Lcom/bestbuy/android/activities/home/HomeTabFragment;

.field private isFromNotification:Z

.field private isFromPLPFragment:Z

.field private isFromRecommendations:Z

.field private isNavigationDrawerOpened:Z

.field private lifeEventsMenuItem:Landroid/view/MenuItem;

.field private lifeEventsMenuItemLayout:Landroid/widget/LinearLayout;

.field private lifeEventsMenuItemTitle:Ljava/lang/String;

.field private lifeEventsNavigationListener:Lcg;

.field private mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

.field private mDrawerList:Landroid/widget/ListView;

.field private mDrawerToggle:Lkc;

.field private mGoogleApiClient:Lqm;

.field private myBBY:Lmr;

.field private myBBYMenuItemView:Landroid/view/View;

.field private onDNMSearchListener:Lcd;

.field private option:Ljava/lang/String;

.field private pageName:Ljava/lang/String;

.field private payloadStr:Ljava/lang/String;

.field private query:Ljava/lang/String;

.field private recommendations:Lmq;

.field private registryData:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

.field private searchIconClickListener:Lch;

.field private searchMenuItem:Landroid/view/MenuItem;

.field private searchView:Landroid/widget/SearchView;

.field private shareItem:Landroid/view/MenuItem;

.field private shareItemll:Landroid/widget/LinearLayout;

.field private spinnerLayout:Landroid/widget/FrameLayout;

.field private storeAvailability:Landroid/view/MenuItem;

.field private storeAvailabiltyClickListener:Lci;

.field private switchToListItem:Landroid/view/MenuItem;

.field private switchToMap:Landroid/view/MenuItem;

.field private tipsString:Ljava/lang/String;

.field private wishListData:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;",
            ">;"
        }
    .end annotation
.end field

.field private wrapperOptionsItem:Landroid/view/MenuItem;

.field private wrapperOptionsItemLayout:Landroid/widget/LinearLayout;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 139
    const-class v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/activities/home/HomeActivity;->TAG:Ljava/lang/String;

    .line 159
    sput-boolean v1, Lcom/bestbuy/android/activities/home/HomeActivity;->inStoresFragment:Z

    .line 160
    sput-boolean v1, Lcom/bestbuy/android/activities/home/HomeActivity;->inListIdSearchFragment:Z

    .line 161
    sput-boolean v1, Lcom/bestbuy/android/activities/home/HomeActivity;->inPDPFragment:Z

    .line 162
    sput-boolean v1, Lcom/bestbuy/android/activities/home/HomeActivity;->inDNMFragment:Z

    .line 164
    sput-boolean v1, Lcom/bestbuy/android/activities/home/HomeActivity;->inLifeEventsFragment:Z

    .line 165
    sput-boolean v1, Lcom/bestbuy/android/activities/home/HomeActivity;->inWrapperFragment:Z

    .line 180
    const-string v0, "http;//www.bestbuy.com"

    sput-object v0, Lcom/bestbuy/android/activities/home/HomeActivity;->productShareURL:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 131
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;-><init>()V

    .line 173
    iput-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->myBBY:Lmr;

    .line 175
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->isNavigationDrawerOpened:Z

    .line 176
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->isFromNotification:Z

    .line 181
    const-string v0, "&#8226 \t Try using fewer or less-specific keywords.<br/> &#8226 \t Double-check your spelling.<br/> &#8226 \t Make sure to add spaces between words."

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->tipsString:Ljava/lang/String;

    .line 185
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->hasOptionsMenu:Z

    .line 188
    new-instance v0, Lmq;

    invoke-direct {v0}, Lmq;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->recommendations:Lmq;

    .line 189
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->isFromRecommendations:Z

    .line 192
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->isFromPLPFragment:Z

    .line 193
    iput-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->payloadStr:Ljava/lang/String;

    .line 840
    new-instance v0, Lcom/bestbuy/android/activities/home/HomeActivity$6;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/home/HomeActivity$6;-><init>(Lcom/bestbuy/android/activities/home/HomeActivity;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->chatMessageReceiver:Landroid/content/BroadcastReceiver;

    .line 1564
    return-void
.end method

.method static synthetic access$002(Lcom/bestbuy/android/activities/home/HomeActivity;Z)Z
    .locals 0

    .prologue
    .line 131
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->isNavigationDrawerOpened:Z

    return p1
.end method

.method static synthetic access$100(Lcom/bestbuy/android/activities/home/HomeActivity;)V
    .locals 0

    .prologue
    .line 131
    invoke-direct {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onDrawerAction()V

    return-void
.end method

.method static synthetic access$200(Lcom/bestbuy/android/activities/home/HomeActivity;)Landroid/widget/SearchView;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchView:Landroid/widget/SearchView;

    return-object v0
.end method

.method static synthetic access$300(Lcom/bestbuy/android/activities/home/HomeActivity;)Landroid/view/MenuItem;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;

    return-object v0
.end method

.method static synthetic access$400(Lcom/bestbuy/android/activities/home/HomeActivity;)Landroid/view/MenuItem;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->geoLocateItem:Landroid/view/MenuItem;

    return-object v0
.end method

.method static synthetic access$500(Lcom/bestbuy/android/activities/home/HomeActivity;)Landroid/view/MenuItem;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    return-object v0
.end method

.method static synthetic access$600(Lcom/bestbuy/android/activities/home/HomeActivity;)Z
    .locals 1

    .prologue
    .line 131
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->isFromPLPFragment:Z

    return v0
.end method

.method static synthetic access$700(Lcom/bestbuy/android/activities/home/HomeActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->query:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$800(Lcom/bestbuy/android/activities/home/HomeActivity;)Lcom/bestbuy/android/activities/home/HomeTabFragment;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->homeTabFragment:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    return-object v0
.end method

.method private getListener()Landroid/support/v4/app/FragmentManager$OnBackStackChangedListener;
    .locals 1

    .prologue
    .line 1383
    new-instance v0, Lcom/bestbuy/android/activities/home/HomeActivity$7;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/home/HomeActivity$7;-><init>(Lcom/bestbuy/android/activities/home/HomeActivity;)V

    .line 1404
    return-object v0
.end method

.method private getSlideInMenuView(Lmy;)Ljava/util/List;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lmy;",
            ")",
            "Ljava/util/List",
            "<",
            "Lmv;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1020
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 1021
    if-eqz p1, :cond_a

    .line 1022
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    invoke-virtual {p1}, Lmy;->a()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_a

    .line 1023
    invoke-virtual {p1}, Lmy;->a()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lmx;

    .line 1024
    invoke-virtual {v0}, Lmx;->a()Ljava/lang/String;

    move-result-object v3

    .line 1025
    invoke-virtual {v3}, Ljava/lang/String;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_3

    .line 1026
    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_0

    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_0

    const-string v4, "ACCOUNT"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    :cond_0
    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_1

    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_2

    :cond_1
    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_3

    .line 1028
    :cond_2
    new-instance v4, Lmu;

    invoke-direct {v4}, Lmu;-><init>()V

    .line 1029
    invoke-virtual {v4, v3}, Lmu;->a(Ljava/lang/String;)V

    .line 1030
    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1033
    :cond_3
    invoke-virtual {v0}, Lmx;->b()Ljava/util/ArrayList;

    move-result-object v0

    .line 1034
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_4
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_9

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lmw;

    .line 1035
    invoke-static {}, Lcom/inc247/ApplicationStatusModel/ChatRunningStatus;->getChatRunning()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 1036
    invoke-virtual {v0}, Lmw;->i()Ljava/lang/String;

    move-result-object v4

    const-string v5, "AskBlueShirt"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_4

    .line 1040
    :cond_5
    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1041
    invoke-virtual {v0}, Lmw;->i()Ljava/lang/String;

    move-result-object v4

    const-string v5, "MyEmptyWeddingRegistryList"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 1042
    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_8

    .line 1043
    invoke-interface {v2, v0}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 1049
    :cond_6
    :goto_2
    invoke-virtual {v0}, Lmw;->i()Ljava/lang/String;

    move-result-object v4

    const-string v5, "MobileDevices"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_7

    .line 1051
    invoke-interface {v2, v0}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 1058
    :cond_7
    sget-boolean v4, Lna;->a:Z

    if-nez v4, :cond_4

    .line 1059
    invoke-virtual {v0}, Lmw;->i()Ljava/lang/String;

    move-result-object v4

    const-string v5, "AppSettings"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 1060
    invoke-interface {v2, v0}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_1

    .line 1044
    :cond_8
    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_6

    invoke-static {}, Lfr;->g()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-nez v4, :cond_6

    .line 1045
    invoke-interface {v2, v0}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_2

    .line 1022
    :cond_9
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto/16 :goto_0

    .line 1066
    :cond_a
    return-object v2
.end method

.method private isGPSEnabled()Z
    .locals 2

    .prologue
    .line 1525
    const-string v0, "location"

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    .line 1526
    const-string v1, "gps"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method private onDrawerAction()V
    .locals 4

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 304
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 305
    const v3, 0x7f0c0033

    invoke-virtual {v0, v3}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 306
    instance-of v0, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v0, :cond_0

    .line 307
    iget-object v3, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->isNavigationDrawerOpened:Z

    if-nez v0, :cond_1

    move v0, v1

    :goto_0
    invoke-interface {v3, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 315
    sget-boolean v0, Lcom/bestbuy/android/activities/home/HomeActivity;->inStoresFragment:Z

    if-eqz v0, :cond_0

    .line 316
    iget-object v3, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->isNavigationDrawerOpened:Z

    if-nez v0, :cond_2

    move v0, v1

    :goto_1
    invoke-interface {v3, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 317
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->geoLocateItem:Landroid/view/MenuItem;

    iget-boolean v3, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->isNavigationDrawerOpened:Z

    if-nez v3, :cond_3

    :goto_2
    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 320
    :cond_0
    return-void

    :cond_1
    move v0, v2

    .line 307
    goto :goto_0

    :cond_2
    move v0, v2

    .line 316
    goto :goto_1

    :cond_3
    move v1, v2

    .line 317
    goto :goto_2
.end method

.method private openWebFragment(Ljava/lang/String;)V
    .locals 4

    .prologue
    const/4 v2, 0x1

    .line 864
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 865
    new-instance v1, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v1, v2, v2}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>(ZZ)V

    .line 866
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 867
    const-string v3, "mDotURL"

    invoke-virtual {v2, v3, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 868
    invoke-virtual {v1, v2}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 869
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 870
    const v2, 0x7f0c0033

    const-string v3, "MdotWebFragment"

    invoke-virtual {v0, v2, v1, v3}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 871
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 872
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 873
    return-void
.end method

.method private productSearch(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 813
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->homeTabFragment:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v0, :cond_0

    .line 814
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->homeTabFragment:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 815
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->spinnerLayout:Landroid/widget/FrameLayout;

    invoke-virtual {v0, p1, v1}, Lcom/bestbuy/android/base/BBYBaseFragment;->a(Ljava/lang/String;Landroid/widget/FrameLayout;)V

    .line 817
    :cond_0
    return-void
.end method

.method private selectItem(I)V
    .locals 4

    .prologue
    .line 935
    new-instance v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->homeTabFragment:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 936
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 937
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 938
    const v1, 0x7f0c0033

    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->homeTabFragment:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    const-string v3, "HomeTabFragment"

    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 939
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 940
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 941
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mDrawerList:Landroid/widget/ListView;

    const/4 v1, 0x1

    invoke-virtual {v0, p1, v1}, Landroid/widget/ListView;->setItemChecked(IZ)V

    .line 942
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mDrawerList:Landroid/widget/ListView;

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(Landroid/view/View;)V

    .line 943
    return-void
.end method

.method private showLifeEventsTopNavigationButton()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 1712
    sput-boolean v2, Lcom/bestbuy/android/activities/home/HomeActivity;->inLifeEventsFragment:Z

    .line 1713
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1714
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->geoLocateItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1715
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1716
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->shareItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1717
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->addToItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1718
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->lifeEventsMenuItem:Landroid/view/MenuItem;

    invoke-interface {v0, v2}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1719
    return-void
.end method


# virtual methods
.method public addFragment(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 1837
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 1838
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 1839
    invoke-virtual {v0, p1, p2, p3}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 1840
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 1841
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 1842
    return-void
.end method

.method public buildSideMenu()V
    .locals 5

    .prologue
    .line 958
    const/4 v1, 0x0

    .line 960
    :try_start_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    const-string v2, "sidemenucards.json"

    invoke-virtual {v0, v2}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v0

    .line 961
    invoke-static {v0}, Lni;->a(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v0

    .line 962
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v2

    invoke-virtual {v2}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    const-string v3, "Sidemenu"

    invoke-interface {v2, v3, v0}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 963
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v2, "Sidemenu"

    const-string v3, ""

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 964
    new-instance v0, Lmy;

    const-string v3, "Sidemenu"

    invoke-direct {v0, v2, v3}, Lmy;-><init>(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 968
    :goto_0
    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSlideInMenuView(Lmy;)Ljava/util/List;

    move-result-object v0

    .line 969
    new-instance v1, Ldz;

    invoke-direct {v1, p0, v0}, Ldz;-><init>(Landroid/content/Context;Ljava/util/List;)V

    .line 970
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mDrawerList:Landroid/widget/ListView;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 971
    return-void

    .line 965
    :catch_0
    move-exception v0

    .line 966
    sget-object v2, Lcom/bestbuy/android/activities/home/HomeActivity;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Could not load Sidemenu data: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lkf;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v1

    goto :goto_0
.end method

.method public changeOptionsVisibility(Z)V
    .locals 0

    .prologue
    .line 644
    return-void
.end method

.method public changeSearchBarVisibility(Z)V
    .locals 2

    .prologue
    .line 627
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 628
    if-eqz p1, :cond_1

    .line 629
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 634
    :cond_0
    :goto_0
    return-void

    .line 631
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    goto :goto_0
.end method

.method public changeStoresSearchVisibility(Z)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 651
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 652
    if-eqz p1, :cond_1

    .line 653
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 654
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->geoLocateItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 655
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 662
    :cond_0
    :goto_0
    return-void

    .line 657
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-interface {v0, v2}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 658
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->geoLocateItem:Landroid/view/MenuItem;

    invoke-interface {v0, v2}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 659
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;

    invoke-interface {v0, v2}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    goto :goto_0
.end method

.method public closeSideMenu()V
    .locals 1

    .prologue
    .line 1070
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v0}, Landroid/support/v4/widget/DrawerLayout;->closeDrawers()V

    .line 1071
    return-void
.end method

.method public customerAlsoBoughtRecommendations(Ljava/util/ArrayList;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 589
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->recommendations:Lmq;

    invoke-virtual {v0, p1}, Lmq;->a(Ljava/util/ArrayList;)V

    .line 590
    return-void
.end method

.method public customerAlsoViewedRecommendations(Ljava/util/ArrayList;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 593
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->recommendations:Lmq;

    invoke-virtual {v0, p1}, Lmq;->b(Ljava/util/ArrayList;)V

    .line 594
    return-void
.end method

.method public disableNextButton()V
    .locals 0

    .prologue
    .line 670
    return-void
.end method

.method public enableNextButton()V
    .locals 0

    .prologue
    .line 666
    return-void
.end method

.method public fragmentHasOptionsMenu(Z)V
    .locals 0

    .prologue
    .line 1854
    return-void
.end method

.method public getActivateLayout()Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 1521
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->activateBanner:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method public getStoreAvailability()Landroid/view/MenuItem;
    .locals 1

    .prologue
    .line 713
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->storeAvailability:Landroid/view/MenuItem;

    return-object v0
.end method

.method public hideLifeEventsTopNavigationButton()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 1722
    sput-boolean v1, Lcom/bestbuy/android/activities/home/HomeActivity;->inLifeEventsFragment:Z

    .line 1723
    sget-boolean v0, Lcom/bestbuy/android/activities/home/HomeActivity;->inStoresFragment:Z

    if-nez v0, :cond_1

    .line 1724
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 1725
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1726
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->geoLocateItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_1

    .line 1727
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->geoLocateItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1730
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->shareItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1731
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->addToItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1732
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->lifeEventsMenuItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1733
    return-void
.end method

.method public instantiateSearch()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 1677
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1678
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchView:Landroid/widget/SearchView;

    invoke-virtual {v0, v2}, Landroid/widget/SearchView;->setVisibility(I)V

    .line 1679
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->expandActionView()Z

    .line 1680
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchView:Landroid/widget/SearchView;

    invoke-virtual {v0, v2}, Landroid/widget/SearchView;->setIconified(Z)V

    .line 1681
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchView:Landroid/widget/SearchView;

    invoke-virtual {v0}, Landroid/widget/SearchView;->requestFocus()Z

    .line 1682
    return-void
.end method

.method public instantiateSearch(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 1685
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->instantiateSearch()V

    .line 1686
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchView:Landroid/widget/SearchView;

    if-eqz v0, :cond_0

    .line 1687
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchView:Landroid/widget/SearchView;

    invoke-virtual {v0, p1}, Landroid/widget/SearchView;->setQueryHint(Ljava/lang/CharSequence;)V

    .line 1689
    :cond_0
    return-void
.end method

.method public loadMostPopularRecommendations(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 597
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->recommendations:Lmq;

    invoke-virtual {v0, p3}, Lmq;->c(Ljava/util/ArrayList;)V

    .line 598
    const/4 v0, 0x0

    invoke-virtual {p3, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getEp()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, p2, v0, p1}, Lcom/bestbuy/android/activities/home/HomeActivity;->sendRecommendations(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 599
    return-void
.end method

.method public loadTrendingNowRecommendations(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 602
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->recommendations:Lmq;

    invoke-virtual {v0, p3}, Lmq;->d(Ljava/util/ArrayList;)V

    .line 603
    const/4 v0, 0x0

    invoke-virtual {p3, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getEp()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, p2, v0, p1}, Lcom/bestbuy/android/activities/home/HomeActivity;->sendRecommendations(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 604
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 6

    .prologue
    const/4 v3, 0x0

    const v1, 0x7f0c0230

    const/4 v4, 0x0

    const/4 v0, -0x1

    .line 1749
    invoke-super {p0, p1, p2, p3}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 1750
    sparse-switch p1, :sswitch_data_0

    .line 1834
    :cond_0
    :goto_0
    return-void

    .line 1752
    :sswitch_0
    if-ne p2, v0, :cond_0

    .line 1754
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->buildSideMenu()V

    goto :goto_0

    .line 1758
    :sswitch_1
    if-ne p2, v0, :cond_0

    .line 1759
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "sku"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1760
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "productId"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1761
    invoke-virtual {p0, v0, v1, v4}, Lcom/bestbuy/android/activities/home/HomeActivity;->openPDP(Ljava/lang/String;Ljava/lang/String;Z)V

    goto :goto_0

    .line 1765
    :sswitch_2
    if-ne p2, v0, :cond_0

    .line 1766
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "sku"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1767
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v2, "productId"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 1768
    const-string v2, ""

    const/4 v5, 0x1

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Lcom/bestbuy/android/activities/home/HomeActivity;->openPDP(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V

    goto :goto_0

    .line 1772
    :sswitch_3
    if-ne p2, v0, :cond_0

    .line 1774
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 1775
    const v1, 0x7f0c0033

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 1776
    if-eqz v0, :cond_1

    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v1, :cond_1

    .line 1777
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 1778
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->d()V

    .line 1780
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->buildSideMenu()V

    goto :goto_0

    .line 1784
    :sswitch_4
    if-ne p2, v0, :cond_0

    .line 1785
    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    .line 1786
    new-instance v1, Ljg;

    const-string v2, "wishlist"

    invoke-direct {v1, p0, v3, v0, v2}, Ljg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v0, Landroid/os/AsyncTask;->THREAD_POOL_EXECUTOR:Ljava/util/concurrent/Executor;

    new-array v2, v4, [Ljava/lang/Void;

    invoke-virtual {v1, v0, v2}, Ljg;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 1790
    :sswitch_5
    if-ne p2, v0, :cond_0

    .line 1791
    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    .line 1792
    new-instance v1, Ljg;

    const-string v2, "weddingregistry"

    invoke-direct {v1, p0, v3, v0, v2}, Ljg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v0, Landroid/os/AsyncTask;->THREAD_POOL_EXECUTOR:Ljava/util/concurrent/Executor;

    new-array v2, v4, [Ljava/lang/Void;

    invoke-virtual {v1, v0, v2}, Ljg;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 1750
    :sswitch_data_0
    .sparse-switch
        0x457 -> :sswitch_0
        0x8ae -> :sswitch_1
        0xd80 -> :sswitch_2
        0x1ed2 -> :sswitch_3
        0x1ed3 -> :sswitch_4
        0x1ed4 -> :sswitch_5
    .end sparse-switch
.end method

.method public onBackPressed()V
    .locals 5

    .prologue
    const v3, 0x7f0c0033

    const/4 v4, 0x0

    .line 1298
    .line 1299
    const-string v0, "input_method"

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 1300
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 1301
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    invoke-virtual {v0, v1, v4}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 1303
    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 1304
    invoke-virtual {v1, v3}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 1305
    instance-of v2, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v2, :cond_3

    .line 1306
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 1308
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTabTag()Ljava/lang/String;

    move-result-object v1

    .line 1309
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Ljava/lang/String;)Z

    move-result v0

    .line 1311
    if-nez v0, :cond_1

    .line 1312
    sget-wide v0, Lcom/bestbuy/android/activities/home/HomeActivity;->backpress:J

    const-wide/16 v2, 0xbb8

    add-long/2addr v0, v2

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-lez v0, :cond_2

    .line 1313
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onBackPressed()V

    .line 1318
    :goto_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    sput-wide v0, Lcom/bestbuy/android/activities/home/HomeActivity;->backpress:J

    .line 1340
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onUserLeaveHint()V

    .line 1380
    :cond_1
    :goto_1
    return-void

    .line 1315
    :cond_2
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getBaseContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080198

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 1343
    :cond_3
    instance-of v2, v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    if-eqz v2, :cond_5

    .line 1344
    check-cast v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    .line 1345
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->d()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 1346
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->e()V

    goto :goto_1

    .line 1349
    :cond_4
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onBackPressed()V

    goto :goto_1

    .line 1350
    :cond_5
    instance-of v2, v0, Lcom/bestbuy/android/activities/appsettings/AppSettingsFragment;

    if-eqz v2, :cond_6

    .line 1351
    check-cast v0, Lcom/bestbuy/android/activities/appsettings/AppSettingsFragment;

    .line 1352
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/appsettings/AppSettingsFragment;->a()V

    .line 1353
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onBackPressed()V

    goto :goto_1

    .line 1354
    :cond_6
    instance-of v2, v0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;

    if-eqz v2, :cond_7

    .line 1358
    :goto_2
    instance-of v0, v0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;

    if-eqz v0, :cond_1

    .line 1359
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->popBackStackImmediate()Z

    .line 1360
    invoke-virtual {v1, v3}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    goto :goto_2

    .line 1362
    :cond_7
    instance-of v1, v0, Lcom/bestbuy/android/activities/registry/MyWeddingRegistryFragment;

    if-eqz v1, :cond_8

    .line 1363
    check-cast v0, Lcom/bestbuy/android/activities/registry/MyWeddingRegistryFragment;

    .line 1364
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/MyWeddingRegistryFragment;->b()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1365
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onBackPressed()V

    goto :goto_1

    .line 1372
    :cond_8
    instance-of v1, v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    if-eqz v1, :cond_9

    .line 1373
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->e()Z

    move-result v0

    .line 1375
    if-nez v0, :cond_1

    .line 1376
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onBackPressed()V

    goto :goto_1

    .line 1378
    :cond_9
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onBackPressed()V

    goto :goto_1
.end method

.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 1864
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->addToItemLayout:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_2

    .line 1865
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 1866
    const v1, 0x7f0c0033

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 1867
    const v0, 0x7f0c0230

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    .line 1868
    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 1870
    new-instance v2, Ljg;

    check-cast v1, Lcom/bestbuy/android/base/BBYBaseFragment;

    const/4 v3, 0x0

    invoke-direct {v2, p0, v1, v0, v3}, Ljg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v0, Landroid/os/AsyncTask;->THREAD_POOL_EXECUTOR:Ljava/util/concurrent/Executor;

    new-array v1, v4, [Ljava/lang/Void;

    invoke-virtual {v2, v0, v1}, Ljg;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 1900
    :cond_0
    :goto_0
    return-void

    .line 1873
    :cond_1
    invoke-static {}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->e()Ljava/util/HashMap;

    move-result-object v0

    .line 1874
    new-instance v2, Lla;

    invoke-direct {v2, p0, v1, v0}, Lla;-><init>(Landroid/content/Context;Landroid/support/v4/app/Fragment;Ljava/util/HashMap;)V

    .line 1875
    invoke-virtual {v2}, Lla;->show()V

    goto :goto_0

    .line 1877
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->lifeEventsMenuItemLayout:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_4

    .line 1878
    const-string v0, "input_method"

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 1879
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_3

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    if-eqz v1, :cond_3

    .line 1880
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    invoke-virtual {v0, v1, v4}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 1882
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->lifeEventsNavigationListener:Lcg;

    invoke-interface {v0}, Lcg;->g()V

    goto :goto_0

    .line 1883
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->shareItemll:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_6

    .line 1884
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 1885
    const-string v1, "android.intent.action.SEND"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 1886
    sget-object v1, Lcom/bestbuy/android/activities/home/HomeActivity;->productShareURL:Ljava/lang/String;

    if-eqz v1, :cond_5

    .line 1887
    const-string v1, "android.intent.extra.TEXT"

    sget-object v2, Lcom/bestbuy/android/activities/home/HomeActivity;->productShareURL:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1889
    :cond_5
    const-string v1, "text/plain"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 1890
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080309

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getText(I)Ljava/lang/CharSequence;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 1891
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->wrapperOptionsItemLayout:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_7

    .line 1892
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->showPopup()V

    goto :goto_0

    .line 1893
    :cond_7
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->clearReviewsLayout:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_0

    .line 1894
    const-string v0, "input_method"

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 1895
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_8

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    if-eqz v1, :cond_8

    .line 1896
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    invoke-virtual {v0, v1, v4}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 1898
    :cond_8
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->clearReviewsClickListener:Lcj;

    invoke-interface {v0}, Lcj;->b()V

    goto/16 :goto_0
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 1

    .prologue
    .line 953
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 954
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mDrawerToggle:Lkc;

    invoke-virtual {v0, p1}, Lkc;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 955
    return-void
.end method

.method public onConnected(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 1531
    sget-object v0, Lahy;->b:Lahr;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mGoogleApiClient:Lqm;

    sget-object v2, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->REQUEST:Lcom/google/android/gms/location/LocationRequest;

    invoke-interface {v0, v1, v2, p0}, Lahr;->a(Lqm;Lcom/google/android/gms/location/LocationRequest;Lahx;)Lqq;

    .line 1532
    return-void
.end method

.method public onConnectionFailed(Lpp;)V
    .locals 3

    .prologue
    .line 1553
    invoke-virtual {p1}, Lpp;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1555
    const/16 v0, 0x2328

    :try_start_0
    invoke-virtual {p1, p0, v0}, Lpp;->a(Landroid/app/Activity;I)V
    :try_end_0
    .catch Landroid/content/IntentSender$SendIntentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1562
    :goto_0
    return-void

    .line 1556
    :catch_0
    move-exception v0

    .line 1557
    invoke-virtual {v0}, Landroid/content/IntentSender$SendIntentException;->printStackTrace()V

    goto :goto_0

    .line 1560
    :cond_0
    sget-object v0, Lcom/bestbuy/android/activities/home/HomeActivity;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Location services connection failed with code "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lpp;->c()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lkf;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onConnectionSuspended(I)V
    .locals 3

    .prologue
    .line 1536
    sget-object v0, Lcom/bestbuy/android/activities/home/HomeActivity;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Location services suspended cause:  "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lkf;->b(Ljava/lang/String;Ljava/lang/String;)V

    .line 1537
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 8

    .prologue
    const/4 v3, 0x1

    const/4 v7, 0x0

    .line 202
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 203
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->appData:Lnb;

    .line 204
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->appData:Lnb;

    invoke-virtual {v0, v3}, Lnb;->f(Z)V

    .line 205
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 206
    sget-object v1, Llu;->bo:Ljava/lang/String;

    const-string v2, "browse,home"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 207
    sget-object v1, Llu;->bp:Ljava/lang/String;

    const-string v2, "GHP"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 208
    sget-object v1, Llu;->a:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 209
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->o()Ljava/util/HashMap;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->o()Ljava/util/HashMap;

    move-result-object v0

    const-string v1, "maintenance_shutdown"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->o()Ljava/util/HashMap;

    move-result-object v0

    const-string v1, "maintenance_shutdown"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const-string v1, "true"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 214
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->appData:Lnb;

    invoke-virtual {v0, v3}, Lnb;->a(Z)V

    .line 215
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/bestbuy/android/activities/home/SplashActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 216
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->startActivity(Landroid/content/Intent;)V

    .line 217
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->finish()V

    .line 295
    :cond_0
    :goto_0
    return-void

    .line 220
    :cond_1
    invoke-direct {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->isGPSEnabled()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 221
    new-instance v0, Lqn;

    invoke-direct {v0, p0}, Lqn;-><init>(Landroid/content/Context;)V

    sget-object v1, Lahy;->a:Lpx;

    invoke-virtual {v0, v1}, Lqn;->a(Lpx;)Lqn;

    move-result-object v0

    invoke-virtual {v0, p0}, Lqn;->a(Lqo;)Lqn;

    move-result-object v0

    invoke-virtual {v0, p0}, Lqn;->a(Lqp;)Lqn;

    move-result-object v0

    invoke-virtual {v0}, Lqn;->b()Lqm;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mGoogleApiClient:Lqm;

    .line 226
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mGoogleApiClient:Lqm;

    invoke-interface {v0}, Lqm;->b()V

    .line 228
    :cond_2
    const v0, 0x7f030054

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->setContentView(I)V

    .line 229
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 230
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/app/ActionBar;->setDisplayShowTitleEnabled(Z)V

    .line 231
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/app/ActionBar;->setDisplayShowCustomEnabled(Z)V

    .line 232
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    const v1, 0x7f03000e

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setCustomView(I)V

    .line 233
    const v0, 0x7f0c0059

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->actionBarTitle:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 234
    const v0, 0x7f0c0058

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    new-instance v1, Lcom/bestbuy/android/activities/home/HomeActivity$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/home/HomeActivity$1;-><init>(Lcom/bestbuy/android/activities/home/HomeActivity;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 240
    const v0, 0x7f0c0064

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->spinnerLayout:Landroid/widget/FrameLayout;

    .line 241
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->showActionBarHome()V

    .line 242
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    const v2, -0xffc49c

    invoke-direct {v1, v2}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 243
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-direct {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getListener()Landroid/support/v4/app/FragmentManager$OnBackStackChangedListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->addOnBackStackChangedListener(Landroid/support/v4/app/FragmentManager$OnBackStackChangedListener;)V

    .line 244
    const v0, 0x7f0c0130

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/DrawerLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    .line 245
    const v0, 0x7f0c0135

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mDrawerList:Landroid/widget/ListView;

    .line 246
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mDrawerList:Landroid/widget/ListView;

    invoke-virtual {v0, v7}, Landroid/widget/ListView;->setVerticalScrollBarEnabled(Z)V

    .line 247
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const v1, 0x7f0200b9

    const v2, 0x800003

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/widget/DrawerLayout;->setDrawerShadow(II)V

    .line 248
    new-instance v0, Lcom/bestbuy/android/activities/home/HomeActivity$2;

    iget-object v3, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const v4, 0x7f020114

    const v5, 0x7f08017b

    const v6, 0x7f08017a

    move-object v1, p0

    move-object v2, p0

    invoke-direct/range {v0 .. v6}, Lcom/bestbuy/android/activities/home/HomeActivity$2;-><init>(Lcom/bestbuy/android/activities/home/HomeActivity;Landroid/app/Activity;Landroid/support/v4/widget/DrawerLayout;III)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mDrawerToggle:Lkc;

    .line 263
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mDrawerToggle:Lkc;

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/DrawerLayout;->setDrawerListener(Landroid/support/v4/widget/DrawerLayout$DrawerListener;)V

    .line 264
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->buildSideMenu()V

    .line 265
    invoke-static {p0}, Landroid/support/v4/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->chatMessageReceiver:Landroid/content/BroadcastReceiver;

    new-instance v2, Landroid/content/IntentFilter;

    const-string v3, "chatstatus"

    invoke-direct {v2, v3}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/content/LocalBroadcastManager;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V

    .line 267
    if-nez p1, :cond_3

    .line 268
    invoke-direct {p0, v7}, Lcom/bestbuy/android/activities/home/HomeActivity;->selectItem(I)V

    .line 270
    :cond_3
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->appData:Lnb;

    .line 271
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->appData:Lnb;

    invoke-virtual {v0}, Lnb;->w()Lmr;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->myBBY:Lmr;

    .line 272
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_4

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.bestbuy.android.NOTIFICATION"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 273
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 274
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->showNotification(Landroid/os/Bundle;)V

    .line 277
    :cond_4
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 279
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "push_received_payload"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 280
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "push_received_payload"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->payloadStr:Ljava/lang/String;

    goto/16 :goto_0

    .line 282
    :cond_5
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "_x"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 283
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "_x"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 290
    :goto_1
    if-eqz v0, :cond_0

    .line 291
    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->openWebFragment(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 284
    :cond_6
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "_od"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 285
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "_od"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 287
    :cond_7
    const/4 v0, 0x0

    .line 288
    const-string v1, "No website URL found in payload."

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->setTitle(Ljava/lang/CharSequence;)V

    goto :goto_1
.end method

.method public onCreateMyEmptyRegistryFragmentExit()V
    .locals 0

    .prologue
    .line 1739
    return-void
.end method

.method public onCreateMyEmptyRegistryFragmentLaunch()V
    .locals 0

    .prologue
    .line 1743
    invoke-direct {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->showLifeEventsTopNavigationButton()V

    .line 1744
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 324
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    .line 325
    const v1, 0x7f0f0004

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 327
    const v0, 0x7f0c044f

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    .line 328
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v0

    .line 329
    check-cast v0, Landroid/widget/SearchView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchView:Landroid/widget/SearchView;

    .line 330
    const-string v0, "search"

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/SearchManager;

    .line 331
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getComponentName()Landroid/content/ComponentName;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/SearchManager;->getSearchableInfo(Landroid/content/ComponentName;)Landroid/app/SearchableInfo;

    move-result-object v0

    .line 332
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchView:Landroid/widget/SearchView;

    invoke-virtual {v1, v0}, Landroid/widget/SearchView;->setSearchableInfo(Landroid/app/SearchableInfo;)V

    .line 335
    :try_start_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchView:Landroid/widget/SearchView;

    invoke-virtual {v0}, Landroid/widget/SearchView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const-string v1, "android:id/search_src_text"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    .line 336
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchView:Landroid/widget/SearchView;

    invoke-virtual {v0, v1}, Landroid/widget/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 337
    const/4 v2, -0x1

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setTextColor(I)V

    .line 338
    const v2, -0x777778

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setHintTextColor(I)V

    .line 339
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    const/16 v2, 0xa

    invoke-interface {v0, v2}, Landroid/view/MenuItem;->setShowAsActionFlags(I)Landroid/view/MenuItem;

    .line 340
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchView:Landroid/widget/SearchView;

    invoke-virtual {v0, v1}, Landroid/widget/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/AutoCompleteTextView;

    .line 341
    const-class v1, Landroid/widget/TextView;

    const-string v2, "mCursorDrawableRes"

    invoke-virtual {v1, v2}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v1

    .line 342
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 343
    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 345
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchView:Landroid/widget/SearchView;

    new-instance v1, Lcom/bestbuy/android/activities/home/HomeActivity$3;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/home/HomeActivity$3;-><init>(Lcom/bestbuy/android/activities/home/HomeActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/SearchView;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 362
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchView:Landroid/widget/SearchView;

    new-instance v1, Lcom/bestbuy/android/activities/home/HomeActivity$4;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/home/HomeActivity$4;-><init>(Lcom/bestbuy/android/activities/home/HomeActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/SearchView;->setOnQueryTextFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 392
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchView:Landroid/widget/SearchView;

    new-instance v1, Lcom/bestbuy/android/activities/home/HomeActivity$5;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/home/HomeActivity$5;-><init>(Lcom/bestbuy/android/activities/home/HomeActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/SearchView;->setOnSearchClickListener(Landroid/view/View$OnClickListener;)V

    .line 404
    const v0, 0x7f0c0450

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->geoLocateItem:Landroid/view/MenuItem;

    .line 405
    const v0, 0x7f0c0451

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;

    .line 406
    const v0, 0x7f0c0452

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToMap:Landroid/view/MenuItem;

    .line 407
    const v0, 0x7f0c0454

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->shareItem:Landroid/view/MenuItem;

    .line 408
    const v0, 0x7f0c0455

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->lifeEventsMenuItem:Landroid/view/MenuItem;

    .line 409
    const v0, 0x7f0c0453

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->addToItem:Landroid/view/MenuItem;

    .line 410
    const v0, 0x7f0c0456

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->clearReviewsItem:Landroid/view/MenuItem;

    .line 411
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->clearReviewsItem:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->clearReviewsLayout:Landroid/widget/LinearLayout;

    .line 412
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->clearReviewsLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 414
    const v0, 0x7f0c044e

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->storeAvailability:Landroid/view/MenuItem;

    .line 415
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->addToItem:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->addToItemLayout:Landroid/widget/LinearLayout;

    .line 416
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->addToItemLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 417
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->lifeEventsMenuItem:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->lifeEventsMenuItemLayout:Landroid/widget/LinearLayout;

    .line 418
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->lifeEventsMenuItemLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 419
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->lifeEventsMenuItemLayout:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0150

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->lifeEventsMenuItemTitle:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 420
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->shareItem:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->shareItemll:Landroid/widget/LinearLayout;

    .line 421
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->shareItemll:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 422
    const v0, 0x7f0c03b3

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->wrapperOptionsItem:Landroid/view/MenuItem;

    .line 423
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->wrapperOptionsItem:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->wrapperOptionsItemLayout:Landroid/widget/LinearLayout;

    .line 424
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->wrapperOptionsItemLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 425
    return v4

    .line 358
    :catch_0
    move-exception v0

    .line 359
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_0
.end method

.method public onCreateRegistryFragmentExit()V
    .locals 0

    .prologue
    .line 1704
    return-void
.end method

.method public onCreateRegistryFragmentLaunch()V
    .locals 0

    .prologue
    .line 1708
    invoke-direct {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->showLifeEventsTopNavigationButton()V

    .line 1709
    return-void
.end method

.method public onCreateWishListFragmentExit()V
    .locals 0

    .prologue
    .line 1692
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->hideLifeEventsTopNavigationButton()V

    .line 1693
    return-void
.end method

.method public onCreateWishListFragmentLaunch()V
    .locals 0

    .prologue
    .line 1697
    invoke-direct {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->showLifeEventsTopNavigationButton()V

    .line 1698
    return-void
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 1909
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onDestroy()V

    .line 1910
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mGoogleApiClient:Lqm;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mGoogleApiClient:Lqm;

    invoke-interface {v0}, Lqm;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1911
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mGoogleApiClient:Lqm;

    invoke-interface {v0}, Lqm;->c()V

    .line 1914
    :cond_0
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->query:Ljava/lang/String;

    .line 1915
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 2

    .prologue
    .line 1285
    const/4 v0, 0x4

    if-ne p1, v0, :cond_0

    .line 1286
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->collapseActionView()Z

    .line 1288
    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 1289
    invoke-super {p0, p1, p2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method public onLocationChanged(Landroid/location/Location;)V
    .locals 4

    .prologue
    .line 1541
    if-eqz p1, :cond_0

    .line 1542
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->appData:Lnb;

    invoke-virtual {p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lnb;->a(D)V

    .line 1543
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->appData:Lnb;

    invoke-virtual {p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lnb;->b(D)V

    .line 1544
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mGoogleApiClient:Lqm;

    invoke-interface {v0}, Lqm;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1545
    sget-object v0, Lahy;->b:Lahr;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mGoogleApiClient:Lqm;

    invoke-interface {v0, v1, p0}, Lahr;->a(Lqm;Lahx;)Lqq;

    .line 1546
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mGoogleApiClient:Lqm;

    invoke-interface {v0}, Lqm;->c()V

    .line 1549
    :cond_0
    return-void
.end method

.method public onMenuClick(Lmw;)V
    .locals 12

    .prologue
    const v10, 0x7f040005

    const/4 v3, 0x0

    const/4 v2, 0x0

    const v9, 0x7f0c0033

    const/4 v8, 0x1

    .line 1075
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v0}, Landroid/support/v4/widget/DrawerLayout;->closeDrawers()V

    .line 1076
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onStoresFramentExit()V

    .line 1077
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v4

    .line 1078
    invoke-virtual {v4}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    .line 1079
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v5, 0x20

    invoke-virtual {v0, v5}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 1080
    invoke-virtual {p1}, Lmw;->e()Ljava/lang/String;

    move-result-object v0

    const-string v5, "bbyDIViewController"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lmw;->e()Ljava/lang/String;

    move-result-object v0

    const-string v5, "bbyWebViewController"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 1083
    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v3, 0x10

    invoke-virtual {v0, v3}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 1084
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 1085
    invoke-virtual {p1}, Lmw;->d()Ljava/lang/String;

    move-result-object v3

    const-string v4, "Order Status"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 1086
    sget-object v3, Llu;->bo:Ljava/lang/String;

    const-string v4, "profile,orderListing"

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1087
    sget-object v3, Llu;->bp:Ljava/lang/String;

    const-string v4, "MAO"

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1088
    sget-object v3, Llu;->h:Ljava/lang/String;

    invoke-static {v3, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 1108
    :cond_1
    :goto_0
    invoke-virtual {p1}, Lmw;->f()Ljava/lang/String;

    move-result-object v3

    .line 1114
    invoke-virtual {p1}, Lmw;->j()Ljava/lang/String;

    move-result-object v4

    .line 1116
    if-eqz v4, :cond_8

    invoke-virtual {v4}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_8

    .line 1117
    new-instance v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v0, v8, v8, v4}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>(ZZLjava/lang/String;)V

    .line 1121
    :goto_1
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 1122
    const-string v5, "mDotURL"

    invoke-virtual {v4, v5, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1123
    invoke-virtual {v0, v4}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 1124
    const-string v3, "MdotWebFragment"

    invoke-virtual {v1, v9, v0, v3}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 1125
    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 1126
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 1281
    :cond_2
    :goto_2
    return-void

    .line 1089
    :cond_3
    invoke-virtual {p1}, Lmw;->d()Ljava/lang/String;

    move-result-object v3

    const-string v4, "Upgrade Checker"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 1090
    sget-object v3, Llu;->bo:Ljava/lang/String;

    const-string v4, "browse,service"

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1091
    sget-object v3, Llu;->bp:Ljava/lang/String;

    const-string v4, "SERV"

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1092
    sget-object v3, Llu;->i:Ljava/lang/String;

    invoke-static {v3, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_0

    .line 1093
    :cond_4
    invoke-virtual {p1}, Lmw;->d()Ljava/lang/String;

    move-result-object v3

    const-string v4, "Trade-In Center"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 1094
    sget-object v3, Llu;->bo:Ljava/lang/String;

    const-string v4, "browse,service"

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1095
    sget-object v3, Llu;->bp:Ljava/lang/String;

    const-string v4, "SERV"

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1096
    sget-object v3, Llu;->j:Ljava/lang/String;

    invoke-static {v3, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_0

    .line 1097
    :cond_5
    invoke-virtual {p1}, Lmw;->d()Ljava/lang/String;

    move-result-object v3

    const-string v4, "Product Recalls"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 1098
    sget-object v3, Llu;->bo:Ljava/lang/String;

    const-string v4, "browse,service"

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1099
    sget-object v3, Llu;->bp:Ljava/lang/String;

    const-string v4, "SERV"

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1100
    sget-object v3, Llu;->k:Ljava/lang/String;

    invoke-static {v3, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    goto/16 :goto_0

    .line 1101
    :cond_6
    invoke-virtual {p1}, Lmw;->d()Ljava/lang/String;

    move-result-object v3

    const-string v4, "Contact Best Buy"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_7

    .line 1102
    sget-object v0, Llu;->o:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 1103
    :cond_7
    invoke-virtual {p1}, Lmw;->d()Ljava/lang/String;

    move-result-object v3

    const-string v4, "Submit Feedback"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 1104
    sget-object v3, Llu;->bo:Ljava/lang/String;

    const-string v4, "browse,service"

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1105
    sget-object v3, Llu;->bp:Ljava/lang/String;

    const-string v4, "SERV"

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1106
    sget-object v3, Llu;->u:Ljava/lang/String;

    invoke-static {v3, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    goto/16 :goto_0

    .line 1119
    :cond_8
    new-instance v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v0, v8, v8}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>(ZZ)V

    goto/16 :goto_1

    .line 1127
    :cond_9
    invoke-virtual {p1}, Lmw;->e()Ljava/lang/String;

    move-result-object v0

    const-string v5, "bbyScanViewController"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 1128
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 1129
    sget-object v1, Llu;->bo:Ljava/lang/String;

    const-string v2, "browse,service"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1130
    sget-object v1, Llu;->bp:Ljava/lang/String;

    const-string v2, "SERV"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1131
    sget-object v1, Llu;->l:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 1132
    new-instance v0, Lmf;

    invoke-direct {v0}, Lmf;-><init>()V

    const-string v1, "CODE_SCAN"

    const-string v2, ""

    invoke-virtual {v0, p0, v1, v2}, Lmf;->a(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_2

    .line 1133
    :cond_a
    invoke-virtual {p1}, Lmw;->e()Ljava/lang/String;

    move-result-object v0

    const-string v5, "bbyGiftCardScanViewController"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 1134
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 1135
    sget-object v3, Llu;->bo:Ljava/lang/String;

    const-string v4, "browse,service"

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1136
    sget-object v3, Llu;->bp:Ljava/lang/String;

    const-string v4, "GCB"

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1137
    sget-object v3, Llu;->m:Ljava/lang/String;

    invoke-static {v3, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 1138
    new-instance v0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;-><init>()V

    .line 1139
    const-string v3, "ManualEnterGiftCardDetailsFragment"

    invoke-virtual {v1, v9, v0, v3}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 1140
    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 1141
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    goto/16 :goto_2

    .line 1142
    :cond_b
    invoke-virtual {p1}, Lmw;->e()Ljava/lang/String;

    move-result-object v0

    const-string v5, "MyEmptyWeddingRegistryList"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c

    .line 1143
    new-instance v0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;-><init>()V

    .line 1144
    const-string v3, "EmptyWeddingRegistryContainer"

    invoke-virtual {v1, v9, v0, v3}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 1145
    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 1146
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    goto/16 :goto_2

    .line 1147
    :cond_c
    invoke-virtual {p1}, Lmw;->e()Ljava/lang/String;

    move-result-object v0

    const-string v5, "MyWishListsFragment"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_e

    .line 1148
    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_d

    .line 1149
    new-instance v0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;

    iget-object v3, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->option:Ljava/lang/String;

    invoke-direct {v0, v3}, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;-><init>(Ljava/lang/String;)V

    .line 1150
    const-string v3, "WishListFragmentContainer"

    invoke-virtual {v1, v9, v0, v3}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 1151
    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 1152
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    goto/16 :goto_2

    .line 1154
    :cond_d
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1155
    const/16 v1, 0x1ed2

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 1156
    const v0, 0x7f04000e

    invoke-virtual {p0, v0, v10}, Lcom/bestbuy/android/activities/home/HomeActivity;->overridePendingTransition(II)V

    goto/16 :goto_2

    .line 1158
    :cond_e
    invoke-virtual {p1}, Lmw;->e()Ljava/lang/String;

    move-result-object v0

    const-string v5, "HelpMenuActivity"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_f

    .line 1159
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1160
    sget-object v1, Lnb;->k:Ljava/lang/String;

    sget-object v2, Lnb;->m:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1161
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->startActivity(Landroid/content/Intent;)V

    .line 1162
    const v0, 0x7f04000e

    invoke-virtual {p0, v0, v10}, Lcom/bestbuy/android/activities/home/HomeActivity;->overridePendingTransition(II)V

    goto/16 :goto_2

    .line 1163
    :cond_f
    invoke-virtual {p1}, Lmw;->e()Ljava/lang/String;

    move-result-object v0

    const-string v5, "RegistryAndGiftsFragment"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_10

    .line 1164
    new-instance v0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;-><init>()V

    .line 1165
    new-instance v3, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;

    invoke-direct {v3}, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;-><init>()V

    .line 1166
    const-string v4, "RegistryFragmentContainer"

    invoke-virtual {v1, v9, v0, v4}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 1167
    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 1168
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 1169
    const-string v1, "RegistryAndGiftsFragment"

    invoke-virtual {v0, v3, v8, v1}, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    goto/16 :goto_2

    .line 1170
    :cond_10
    invoke-virtual {p1}, Lmw;->e()Ljava/lang/String;

    move-result-object v0

    const-string v5, "bbyAlertViewController"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_11

    .line 1171
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 1172
    sget-object v3, Llu;->bo:Ljava/lang/String;

    const-string v4, "browse,promo"

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1173
    sget-object v3, Llu;->bp:Ljava/lang/String;

    const-string v4, "PRPT"

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1174
    sget-object v3, Llu;->n:Ljava/lang/String;

    invoke-static {v3, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 1175
    new-instance v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v0, v8, v8}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>(ZZ)V

    .line 1176
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 1177
    const-string v4, "mDotURL"

    iget-object v5, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->appData:Lnb;

    invoke-virtual {v5}, Lnb;->d()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1178
    invoke-virtual {v0, v3}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 1179
    const-string v3, "MdotWebFragment"

    invoke-virtual {v1, v9, v0, v3}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 1180
    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 1181
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    goto/16 :goto_2

    .line 1182
    :cond_11
    invoke-virtual {p1}, Lmw;->e()Ljava/lang/String;

    move-result-object v0

    const-string v5, "ContactBestBuyFragment"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_12

    .line 1183
    new-instance v1, Landroid/content/Intent;

    const-string v0, "android.intent.action.SEND"

    invoke-direct {v1, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1184
    const-string v0, "text/html"

    invoke-virtual {v1, v0}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 1185
    const-string v0, "android.intent.extra.EMAIL"

    new-array v2, v8, [Ljava/lang/String;

    const-string v4, "onlinestore@bestbuy.com"

    aput-object v4, v2, v3

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/Intent;

    .line 1187
    :try_start_0
    const-string v0, "android.intent.extra.SUBJECT"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Best Buy Mobile App Feedback ("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getPackageName()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v3

    iget-object v3, v3, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ")"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1191
    :goto_3
    const-string v0, "android.intent.extra.TEXT"

    const-string v2, ""

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1192
    const-string v0, ""

    invoke-static {v1, v0}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_2

    .line 1188
    :catch_0
    move-exception v0

    .line 1189
    invoke-virtual {v0}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_3

    .line 1194
    :cond_12
    invoke-virtual {p1}, Lmw;->e()Ljava/lang/String;

    move-result-object v5

    .line 1195
    const-string v0, "HomeTabFragment"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_13

    .line 1196
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v6

    move v0, v3

    .line 1197
    :goto_4
    add-int/lit8 v7, v6, -0x1

    if-ge v0, v7, :cond_13

    .line 1198
    invoke-virtual {v4}, Landroid/support/v4/app/FragmentManager;->popBackStackImmediate()Z

    .line 1197
    add-int/lit8 v0, v0, 0x1

    goto :goto_4

    .line 1201
    :cond_13
    const-string v0, "StoreSearchMapFragment"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_16

    .line 1202
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onStoresFramentLaunch()V

    .line 1203
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0, v9}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 1204
    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v1, :cond_14

    .line 1205
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 1206
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v1

    const/4 v2, 0x2

    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentTabHost;->setCurrentTab(I)V

    .line 1207
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 1208
    if-eqz v0, :cond_2

    instance-of v1, v0, Lcom/bestbuy/android/activities/stores/StoreTabContainer;

    if-eqz v1, :cond_2

    .line 1209
    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/BaseTabContainer;->c()V

    goto/16 :goto_2

    .line 1211
    :cond_14
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v0

    .line 1212
    :goto_5
    add-int/lit8 v1, v0, -0x1

    if-ge v3, v1, :cond_15

    .line 1213
    invoke-virtual {v4}, Landroid/support/v4/app/FragmentManager;->popBackStackImmediate()Z

    .line 1212
    add-int/lit8 v3, v3, 0x1

    goto :goto_5

    .line 1215
    :cond_15
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0, v9}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 1216
    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v1, :cond_2

    .line 1217
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 1218
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v0

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTabHost;->setCurrentTab(I)V

    goto/16 :goto_2

    .line 1221
    :cond_16
    const-string v0, "bbyRZViewController"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_17

    .line 1222
    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_2

    .line 1223
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1224
    const/16 v1, 0x1ed2

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 1225
    const v0, 0x7f04000e

    invoke-virtual {p0, v0, v10}, Lcom/bestbuy/android/activities/home/HomeActivity;->overridePendingTransition(II)V

    goto/16 :goto_2

    .line 1227
    :cond_17
    const-string v0, "GameTradeInFragment"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1b

    .line 1229
    const-string v0, "GameTradeInFragment"

    invoke-static {v0}, Lkb;->a(Ljava/lang/String;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v5

    .line 1230
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0, v9}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 1231
    instance-of v0, v1, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v0, :cond_18

    .line 1232
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->appData:Lnb;

    invoke-virtual {v0, v8}, Lnb;->g(Z)V

    .line 1233
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->appData:Lnb;

    invoke-virtual {v0, v5}, Lnb;->a(Landroid/support/v4/app/Fragment;)V

    move-object v0, v1

    .line 1234
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 1235
    invoke-virtual {v0, v8}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->a(I)V

    move-object v11, v1

    move-object v1, v0

    move-object v0, v11

    .line 1247
    :goto_6
    instance-of v2, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v2, :cond_2

    .line 1248
    invoke-virtual {v1}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTab()I

    move-result v2

    if-ne v2, v8, :cond_1a

    .line 1249
    invoke-virtual {v1}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "PRODUCTS"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 1250
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;

    if-eqz v1, :cond_2

    .line 1251
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;

    .line 1252
    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0, v5, v8}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto/16 :goto_2

    .line 1237
    :cond_18
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v1

    move v0, v3

    .line 1238
    :goto_7
    add-int/lit8 v3, v1, -0x1

    if-ge v0, v3, :cond_19

    .line 1239
    invoke-virtual {v4}, Landroid/support/v4/app/FragmentManager;->popBackStackImmediate()Z

    .line 1238
    add-int/lit8 v0, v0, 0x1

    goto :goto_7

    .line 1241
    :cond_19
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0, v9}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 1242
    instance-of v0, v1, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v0, :cond_1f

    move-object v0, v1

    .line 1243
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 1244
    invoke-virtual {v0, v8}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->a(I)V

    move-object v11, v1

    move-object v1, v0

    move-object v0, v11

    goto :goto_6

    .line 1255
    :cond_1a
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->appData:Lnb;

    invoke-virtual {v1, v8}, Lnb;->g(Z)V

    .line 1256
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->appData:Lnb;

    invoke-virtual {v1, v5}, Lnb;->a(Landroid/support/v4/app/Fragment;)V

    .line 1257
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 1258
    invoke-virtual {v0, v8}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->a(I)V

    goto/16 :goto_2

    .line 1262
    :cond_1b
    const-string v0, "AppSettingsFragment"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1c

    const-string v0, "PrivacyTermsFragment"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1e

    .line 1263
    :cond_1c
    const-string v0, "AppSettingsFragment"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1d

    .line 1269
    :cond_1d
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 1271
    iget-object v3, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->appData:Lnb;

    invoke-virtual {v3, v0}, Lnb;->i(Ljava/lang/String;)V

    .line 1272
    const-string v0, ""

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 1273
    invoke-virtual {p0, p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 1275
    :cond_1e
    invoke-static {v5}, Lkb;->a(Ljava/lang/String;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    .line 1276
    invoke-virtual {v1, v9, v0, v5}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 1277
    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 1278
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    goto/16 :goto_2

    :cond_1f
    move-object v0, v1

    move-object v1, v2

    goto/16 :goto_6
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 6

    .prologue
    const/4 v5, 0x1

    .line 748
    const-string v0, "android.intent.action.SEARCH"

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 749
    const-string v0, "query"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 750
    if-nez v0, :cond_a

    .line 751
    invoke-virtual {p1}, Landroid/content/Intent;->getDataString()Ljava/lang/String;

    move-result-object v0

    move-object v2, v0

    .line 753
    :goto_0
    new-instance v0, Lcom/bestbuy/android/providers/SuggestionProvider;

    invoke-direct {v0}, Lcom/bestbuy/android/providers/SuggestionProvider;-><init>()V

    .line 754
    invoke-virtual {v0, p0, v2}, Lcom/bestbuy/android/providers/SuggestionProvider;->a(Landroid/content/Context;Ljava/lang/String;)V

    .line 755
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->collapseActionView()Z

    .line 756
    const-string v0, "ProductScan"

    invoke-virtual {v2, v0}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_1

    .line 757
    new-instance v0, Lmf;

    invoke-direct {v0}, Lmf;-><init>()V

    const-string v1, "CODE_SCAN"

    const-string v2, ""

    invoke-virtual {v0, p0, v1, v2}, Lmf;->a(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)V

    .line 809
    :cond_0
    :goto_1
    return-void

    .line 758
    :cond_1
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 759
    sget-boolean v0, Lcom/bestbuy/android/activities/home/HomeActivity;->inStoresFragment:Z

    if-nez v0, :cond_8

    .line 760
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 761
    const v1, 0x7f0c0033

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 762
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    if-eqz v1, :cond_2

    .line 763
    invoke-direct {p0, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->productSearch(Ljava/lang/String;)V

    goto :goto_1

    .line 765
    :cond_2
    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v1, :cond_7

    .line 766
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 767
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v1

    instance-of v1, v1, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    if-eqz v1, :cond_4

    .line 768
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    .line 769
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 770
    instance-of v0, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;

    if-eqz v0, :cond_3

    .line 771
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->onDNMSearchListener:Lcd;

    invoke-interface {v0, v2}, Lcd;->a(Ljava/lang/String;)V

    .line 772
    iput-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->query:Ljava/lang/String;

    .line 773
    sput-boolean v5, Lcom/bestbuy/android/activities/home/HomeActivity;->inDNMFragment:Z

    goto :goto_1

    .line 775
    :cond_3
    invoke-direct {p0, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->productSearch(Ljava/lang/String;)V

    goto :goto_1

    .line 777
    :cond_4
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v1

    instance-of v1, v1, Lcom/bestbuy/android/activities/stores/StoreTabContainer;

    if-eqz v1, :cond_6

    .line 778
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/activities/stores/StoreTabContainer;

    .line 779
    invoke-virtual {v1}, Lcom/bestbuy/android/activities/stores/StoreTabContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 780
    instance-of v1, v1, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;

    if-eqz v1, :cond_5

    .line 781
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->onDNMSearchListener:Lcd;

    invoke-interface {v0, v2}, Lcd;->a(Ljava/lang/String;)V

    .line 782
    iput-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->query:Ljava/lang/String;

    .line 783
    sput-boolean v5, Lcom/bestbuy/android/activities/home/HomeActivity;->inDNMFragment:Z

    goto :goto_1

    .line 785
    :cond_5
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    invoke-direct {v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;-><init>()V

    .line 786
    new-instance v3, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    const/4 v4, 0x0

    invoke-direct {v3, v2, v4}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;-><init>(Ljava/lang/String;Z)V

    .line 787
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0, v1, v5}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 788
    invoke-virtual {v1, v3, v5}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto/16 :goto_1

    .line 792
    :cond_6
    invoke-direct {p0, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->productSearch(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 798
    :cond_7
    invoke-direct {p0, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->productSearch(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 801
    :cond_8
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->showActionBarHome()V

    .line 802
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->actionIconClickListener:Lcf;

    invoke-interface {v0, v2}, Lcf;->a(Ljava/lang/String;)V

    .line 803
    iput-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->query:Ljava/lang/String;

    goto/16 :goto_1

    .line 806
    :cond_9
    const-string v0, "com.bestbuy.android.NOTIFICATION"

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 807
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->showNotification(Landroid/os/Bundle;)V

    goto/16 :goto_1

    :cond_a
    move-object v2, v0

    goto/16 :goto_0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 5

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 524
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mDrawerToggle:Lkc;

    invoke-virtual {v0, p1}, Lkc;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 573
    :goto_0
    return v1

    .line 527
    :cond_0
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    .line 573
    :cond_1
    :goto_1
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v1

    goto :goto_0

    .line 529
    :sswitch_0
    sget-boolean v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->b:Z

    if-nez v0, :cond_1

    .line 530
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->actionIconClickListener:Lcf;

    invoke-interface {v0}, Lcf;->b()V

    goto :goto_1

    .line 533
    :sswitch_1
    sget-boolean v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->b:Z

    if-nez v0, :cond_1

    .line 534
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->invalidateOptionsMenu()V

    .line 535
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->actionIconClickListener:Lcf;

    invoke-interface {v0}, Lcf;->c()V

    goto :goto_1

    .line 539
    :sswitch_2
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 540
    const-string v1, "android.intent.action.SEND"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 541
    sget-object v1, Lcom/bestbuy/android/activities/home/HomeActivity;->productShareURL:Ljava/lang/String;

    if-eqz v1, :cond_2

    .line 542
    const-string v1, "android.intent.extra.TEXT"

    sget-object v2, Lcom/bestbuy/android/activities/home/HomeActivity;->productShareURL:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 544
    :cond_2
    const-string v1, "text/plain"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 545
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080309

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getText(I)Ljava/lang/CharSequence;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_1

    .line 548
    :sswitch_3
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->invalidateOptionsMenu()V

    .line 549
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->lifeEventsNavigationListener:Lcg;

    invoke-interface {v0}, Lcg;->g()V

    goto :goto_1

    .line 554
    :sswitch_4
    invoke-interface {p1}, Landroid/view/MenuItem;->isChecked()Z

    move-result v0

    if-nez v0, :cond_3

    move v0, v1

    .line 555
    :goto_2
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v3

    invoke-virtual {v3}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v3

    invoke-interface {v3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    const-string v4, "show_availability"

    invoke-interface {v3, v4, v0}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    invoke-interface {v3}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 556
    invoke-interface {p1, v0}, Landroid/view/MenuItem;->setChecked(Z)Landroid/view/MenuItem;

    .line 557
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v3, 0x7f020014

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/StateListDrawable;

    .line 558
    new-array v4, v1, [I

    invoke-interface {p1}, Landroid/view/MenuItem;->isChecked()Z

    move-result v3

    if-eqz v3, :cond_4

    const v3, 0x10100a0

    :goto_3
    aput v3, v4, v2

    .line 559
    invoke-virtual {v0, v4}, Landroid/graphics/drawable/StateListDrawable;->setState([I)Z

    .line 560
    invoke-virtual {v0}, Landroid/graphics/drawable/StateListDrawable;->getCurrent()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-interface {p1, v0}, Landroid/view/MenuItem;->setIcon(Landroid/graphics/drawable/Drawable;)Landroid/view/MenuItem;

    .line 561
    invoke-interface {p1}, Landroid/view/MenuItem;->isChecked()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 562
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->storeAvailabiltyClickListener:Lci;

    invoke-interface {v0, v1}, Lci;->a(Z)V

    goto/16 :goto_1

    :cond_3
    move v0, v2

    .line 554
    goto :goto_2

    .line 558
    :cond_4
    const v3, 0x10100a9

    goto :goto_3

    .line 564
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->storeAvailabiltyClickListener:Lci;

    invoke-interface {v0, v2}, Lci;->a(Z)V

    goto/16 :goto_1

    .line 568
    :sswitch_5
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->showPopup()V

    goto/16 :goto_0

    .line 527
    :sswitch_data_0
    .sparse-switch
        0x7f0c03b3 -> :sswitch_5
        0x7f0c044e -> :sswitch_4
        0x7f0c0450 -> :sswitch_0
        0x7f0c0451 -> :sswitch_1
        0x7f0c0454 -> :sswitch_2
        0x7f0c0455 -> :sswitch_3
    .end sparse-switch
.end method

.method public onPDPFragmentExit()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 1471
    sput-boolean v1, Lcom/bestbuy/android/activities/home/HomeActivity;->inPDPFragment:Z

    .line 1472
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->shareItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 1473
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->shareItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1475
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->addToItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_1

    .line 1476
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->addToItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1481
    :cond_1
    return-void
.end method

.method public onPDPFragmentLaunch()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 1451
    sput-boolean v2, Lcom/bestbuy/android/activities/home/HomeActivity;->inPDPFragment:Z

    .line 1452
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 1453
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1455
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_1

    .line 1456
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1458
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->geoLocateItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_2

    .line 1459
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->geoLocateItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1461
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->shareItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_3

    .line 1462
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->shareItem:Landroid/view/MenuItem;

    invoke-interface {v0, v2}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1467
    :cond_3
    return-void
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 859
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onPause()V

    .line 860
    invoke-static {}, Llu;->a()V

    .line 861
    return-void
.end method

.method protected onPostCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 947
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onPostCreate(Landroid/os/Bundle;)V

    .line 948
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mDrawerToggle:Lkc;

    invoke-virtual {v0}, Lkc;->syncState()V

    .line 949
    return-void
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)Z
    .locals 5

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 430
    iget-boolean v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->isNavigationDrawerOpened:Z

    if-nez v2, :cond_9

    .line 431
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToMap:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 432
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-interface {v2, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 433
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->storeAvailability:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 434
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->wrapperOptionsItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 435
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->shareItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 436
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->lifeEventsMenuItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 437
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->addToItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 438
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->clearReviewsItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 439
    sget-boolean v2, Lcom/bestbuy/android/activities/home/HomeActivity;->inStoresFragment:Z

    if-eqz v2, :cond_3

    .line 440
    sget-boolean v2, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->b:Z

    if-nez v2, :cond_1

    .line 441
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v2

    invoke-virtual {v2}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v2

    const-string v3, "IS_MAP_VIEW"

    invoke-interface {v2, v3, v1}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    .line 442
    iget-object v3, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchView:Landroid/widget/SearchView;

    if-eqz v3, :cond_0

    .line 443
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f080352

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 444
    iget-object v4, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchView:Landroid/widget/SearchView;

    invoke-virtual {v4, v3}, Landroid/widget/SearchView;->setQueryHint(Ljava/lang/CharSequence;)V

    .line 446
    :cond_0
    if-eqz v2, :cond_2

    .line 447
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;

    const v2, 0x7f02010f

    invoke-interface {v0, v2}, Landroid/view/MenuItem;->setIcon(I)Landroid/view/MenuItem;

    .line 448
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v2, "IS_MAP_VIEW"

    invoke-interface {v0, v2, v1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 519
    :cond_1
    :goto_0
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onPrepareOptionsMenu(Landroid/view/Menu;)Z

    move-result v0

    return v0

    .line 450
    :cond_2
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;

    const v2, 0x7f020107

    invoke-interface {v1, v2}, Landroid/view/MenuItem;->setIcon(I)Landroid/view/MenuItem;

    .line 451
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    invoke-virtual {v1}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string v2, "IS_MAP_VIEW"

    invoke-interface {v1, v2, v0}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_0

    .line 454
    :cond_3
    sget-boolean v2, Lcom/bestbuy/android/activities/home/HomeActivity;->inLifeEventsFragment:Z

    if-eqz v2, :cond_4

    sget-boolean v2, Lcom/bestbuy/android/activities/home/HomeActivity;->inPDPFragment:Z

    if-eqz v2, :cond_4

    .line 455
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 456
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->geoLocateItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 457
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 458
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->storeAvailability:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 459
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->shareItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 460
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->addToItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 461
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->clearReviewsItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 462
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->lifeEventsMenuItem:Landroid/view/MenuItem;

    invoke-interface {v2, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 463
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->wrapperOptionsItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    goto :goto_0

    .line 464
    :cond_4
    sget-boolean v2, Lcom/bestbuy/android/activities/home/HomeActivity;->inPDPFragment:Z

    if-eqz v2, :cond_5

    .line 465
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 466
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->geoLocateItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 467
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->lifeEventsMenuItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 468
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 469
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->storeAvailability:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 470
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->shareItem:Landroid/view/MenuItem;

    invoke-interface {v2, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 471
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->wrapperOptionsItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 472
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->clearReviewsItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    goto/16 :goto_0

    .line 476
    :cond_5
    sget-boolean v2, Lcom/bestbuy/android/activities/home/HomeActivity;->inLifeEventsFragment:Z

    if-eqz v2, :cond_6

    .line 477
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 478
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->geoLocateItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 479
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 480
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->storeAvailability:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 481
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->shareItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 482
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->addToItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 483
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->clearReviewsItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 484
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->lifeEventsMenuItem:Landroid/view/MenuItem;

    invoke-interface {v2, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 485
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->wrapperOptionsItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    goto/16 :goto_0

    .line 486
    :cond_6
    sget-boolean v2, Lcom/bestbuy/android/activities/home/HomeActivity;->inWrapperFragment:Z

    if-eqz v2, :cond_7

    .line 487
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 488
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->geoLocateItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 489
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 490
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->storeAvailability:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 491
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->shareItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 492
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->addToItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 493
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->clearReviewsItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 494
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->lifeEventsMenuItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 495
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->wrapperOptionsItem:Landroid/view/MenuItem;

    invoke-interface {v1, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    goto/16 :goto_0

    .line 497
    :cond_7
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 498
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->geoLocateItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 499
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->storeAvailability:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 500
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->shareItem:Landroid/view/MenuItem;

    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 501
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->isActionBarHidden()Z

    move-result v3

    if-nez v3, :cond_8

    :goto_1
    invoke-interface {v2, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 502
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->addToItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 503
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->clearReviewsItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 504
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->lifeEventsMenuItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 505
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->wrapperOptionsItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    goto/16 :goto_0

    :cond_8
    move v0, v1

    .line 501
    goto :goto_1

    .line 508
    :cond_9
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 509
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->geoLocateItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 510
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToMap:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 511
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->storeAvailability:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 512
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 513
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->shareItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 514
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->addToItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 515
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->clearReviewsItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 516
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->lifeEventsMenuItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 517
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->wrapperOptionsItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    goto/16 :goto_0
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 849
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onResume()V

    .line 850
    invoke-static {p0}, Llu;->a(Landroid/app/Activity;)V

    .line 851
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.bestbuy.android.NOTIFICATION"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 852
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 853
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->showNotification(Landroid/os/Bundle;)V

    .line 855
    :cond_0
    return-void
.end method

.method public onStoreDetailsExit()V
    .locals 0

    .prologue
    .line 1658
    return-void
.end method

.method public onStoreDetailsLaunch()V
    .locals 0

    .prologue
    .line 1653
    return-void
.end method

.method public onStoresFramentExit()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 1430
    sput-boolean v1, Lcom/bestbuy/android/activities/home/HomeActivity;->inStoresFragment:Z

    .line 1431
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 1432
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1434
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->geoLocateItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_1

    .line 1435
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->geoLocateItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1437
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchView:Landroid/widget/SearchView;

    if-eqz v0, :cond_2

    .line 1438
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0802ef

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 1439
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchView:Landroid/widget/SearchView;

    invoke-virtual {v1, v0}, Landroid/widget/SearchView;->setQueryHint(Ljava/lang/CharSequence;)V

    .line 1441
    :cond_2
    return-void
.end method

.method public onStoresFramentLaunch()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 1409
    sput-boolean v3, Lcom/bestbuy/android/activities/home/HomeActivity;->inStoresFragment:Z

    .line 1410
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 1411
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;

    invoke-interface {v0, v3}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1412
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "IS_MAP_VIEW"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    .line 1413
    if-eqz v0, :cond_3

    .line 1414
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;

    const v1, 0x7f020107

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setIcon(I)Landroid/view/MenuItem;

    .line 1419
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->geoLocateItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_1

    .line 1420
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->geoLocateItem:Landroid/view/MenuItem;

    invoke-interface {v0, v3}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1422
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchView:Landroid/widget/SearchView;

    if-eqz v0, :cond_2

    .line 1423
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080352

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 1424
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchView:Landroid/widget/SearchView;

    invoke-virtual {v1, v0}, Landroid/widget/SearchView;->setQueryHint(Ljava/lang/CharSequence;)V

    .line 1426
    :cond_2
    return-void

    .line 1416
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;

    const v1, 0x7f02010f

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setIcon(I)Landroid/view/MenuItem;

    goto :goto_0
.end method

.method public onStoresListShown()V
    .locals 3

    .prologue
    .line 1445
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;

    const v1, 0x7f02010f

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setIcon(I)Landroid/view/MenuItem;

    .line 1446
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "IS_MAP_VIEW"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 1447
    return-void
.end method

.method public openLeftNavigation()V
    .locals 2

    .prologue
    .line 1903
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/DrawerLayout;->openDrawer(I)V

    .line 1904
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mDrawerList:Landroid/widget/ListView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setSelection(I)V

    .line 1905
    return-void
.end method

.method public openPDP(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZZZLjava/lang/String;)V
    .locals 11

    .prologue
    .line 877
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v9

    .line 878
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v10

    .line 879
    const v2, 0x7f0c0033

    invoke-virtual {v10, v2}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v8

    .line 881
    if-eqz p4, :cond_0

    .line 882
    new-instance v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    invoke-virtual/range {p5 .. p5}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual/range {p5 .. p5}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getProductId()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x1

    move-object/from16 v6, p5

    move/from16 v7, p6

    invoke-direct/range {v2 .. v7}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;-><init>(Ljava/lang/String;Ljava/lang/String;ZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;Z)V

    move-object v3, v2

    .line 885
    :goto_0
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 886
    const-string v4, "availability_storeid"

    invoke-virtual {v2, v4, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 887
    invoke-virtual {v3, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->setArguments(Landroid/os/Bundle;)V

    .line 888
    move/from16 v0, p7

    invoke-virtual {v3, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->b(Z)V

    .line 889
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->bbyProduct:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    iget-object v4, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->pageName:Ljava/lang/String;

    move/from16 v0, p8

    move-object/from16 v1, p9

    invoke-virtual {v3, v0, v2, v4, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a(ZLcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Ljava/lang/String;Ljava/lang/String;)V

    .line 890
    new-instance v4, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-direct {v4, v9}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;-><init>(Ljava/lang/String;)V

    .line 891
    instance-of v2, v8, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v2, :cond_1

    move-object v2, v8

    .line 892
    check-cast v2, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 893
    invoke-virtual {v2}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v2

    .line 894
    check-cast v2, Lcom/bestbuy/android/activities/BaseTabContainer;

    const/4 v5, 0x1

    invoke-virtual {v2, v4, v5}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 901
    :goto_1
    const/4 v2, 0x1

    invoke-virtual {v4, v3, v2}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 902
    return-void

    .line 884
    :cond_0
    new-instance v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    move/from16 v0, p6

    invoke-direct {v2, p1, p3, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    move-object v3, v2

    goto :goto_0

    .line 896
    :cond_1
    invoke-virtual {v10}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v2

    .line 897
    const v5, 0x7f0c0033

    const-string v6, "PDPFragment"

    invoke-virtual {v2, v5, v4, v6}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 898
    const/4 v5, 0x0

    invoke-virtual {v2, v5}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 899
    invoke-virtual {v2}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    goto :goto_1
.end method

.method public openPDP(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V
    .locals 10

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 921
    iput-boolean v4, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->isFromRecommendations:Z

    .line 922
    iput-object v5, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->bbyProduct:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 923
    const-string v0, "Life Events"

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->pageName:Ljava/lang/String;

    .line 924
    const-string v9, ""

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move v6, p4

    move v7, p5

    move v8, v4

    invoke-virtual/range {v0 .. v9}, Lcom/bestbuy/android/activities/home/HomeActivity;->openPDP(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZZZLjava/lang/String;)V

    .line 925
    return-void
.end method

.method public openPDP(Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 10

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 905
    iput-boolean v4, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->isFromRecommendations:Z

    .line 906
    iput-object v5, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->bbyProduct:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 907
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->pageName:Ljava/lang/String;

    .line 908
    const-string v2, ""

    const-string v9, ""

    move-object v0, p0

    move-object v1, p1

    move-object v3, p2

    move v6, p3

    move v7, v4

    move v8, v4

    invoke-virtual/range {v0 .. v9}, Lcom/bestbuy/android/activities/home/HomeActivity;->openPDP(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZZZLjava/lang/String;)V

    .line 909
    return-void
.end method

.method public openPDP(Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V
    .locals 11

    .prologue
    .line 928
    move/from16 v0, p5

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->isFromRecommendations:Z

    .line 929
    move-object/from16 v0, p7

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->bbyProduct:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 930
    move-object/from16 v0, p6

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->pageName:Ljava/lang/String;

    .line 931
    const-string v3, ""

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v9, 0x0

    const-string v10, ""

    move-object v1, p0

    move-object v2, p1

    move-object v4, p2

    move v7, p3

    move v8, p4

    invoke-virtual/range {v1 .. v10}, Lcom/bestbuy/android/activities/home/HomeActivity;->openPDP(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZZZLjava/lang/String;)V

    .line 932
    return-void
.end method

.method public openPDP(Ljava/lang/String;ZLjava/lang/String;ZLcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Ljava/lang/String;Ljava/lang/String;)V
    .locals 11

    .prologue
    .line 913
    iput-boolean p4, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->isFromRecommendations:Z

    .line 914
    move-object/from16 v0, p5

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->bbyProduct:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 915
    move-object/from16 v0, p6

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->pageName:Ljava/lang/String;

    .line 916
    move-object/from16 v0, p7

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->breadCrumb:Ljava/lang/String;

    .line 917
    const-string v3, ""

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v8, 0x0

    move-object v1, p0

    move-object v2, p1

    move-object v4, p3

    move v7, p2

    move v9, p4

    move-object/from16 v10, p7

    invoke-virtual/range {v1 .. v10}, Lcom/bestbuy/android/activities/home/HomeActivity;->openPDP(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZZZLjava/lang/String;)V

    .line 918
    return-void
.end method

.method public popCurrentFragment()V
    .locals 2

    .prologue
    .line 821
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 822
    const v1, 0x7f0c0033

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 823
    instance-of v1, v1, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-nez v1, :cond_0

    .line 824
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    .line 826
    :cond_0
    return-void
.end method

.method public postOnTwitter(Ljava/lang/String;Z)V
    .locals 3

    .prologue
    const v2, 0x7f08011c

    .line 2026
    if-eqz p2, :cond_0

    .line 2027
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lfr;->e()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lfr;->f()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08011e

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 2030
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.SEND"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 2031
    const-string v2, "android.intent.extra.TEXT"

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 2032
    const-string v0, "android.intent.extra.SUBJECT"

    const-string v2, "A wish list has been shared with you"

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 2033
    const-string v0, "text/plain"

    invoke-virtual {v1, v0}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 2034
    const-string v0, "Share WishList To..."

    invoke-static {v1, v0}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->startActivity(Landroid/content/Intent;)V

    .line 2046
    :goto_0
    return-void

    .line 2037
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lfr;->e()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lfr;->f()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08011d

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 2040
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.SEND"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 2041
    const-string v2, "android.intent.extra.TEXT"

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 2042
    const-string v0, "android.intent.extra.SUBJECT"

    const-string v2, "A wedding registry has been shared with you"

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 2043
    const-string v0, "text/plain"

    invoke-virtual {v1, v0}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 2044
    const-string v0, "Share Registry To..."

    invoke-static {v1, v0}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method public recreateHomeScreen(Z)V
    .locals 3

    .prologue
    .line 1000
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "HomeTabFragment"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 1001
    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v1, :cond_1

    .line 1002
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->homeTabFragment:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 1003
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->homeTabFragment:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v0, :cond_1

    .line 1004
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->homeTabFragment:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    if-eqz v0, :cond_0

    .line 1005
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->homeTabFragment:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    .line 1006
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 1007
    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeFragment;

    if-eqz v1, :cond_0

    .line 1008
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeFragment;->f()V

    .line 1011
    :cond_0
    if-eqz p1, :cond_1

    .line 1012
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080031

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 1013
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->homeTabFragment:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->c()V

    .line 1017
    :cond_1
    return-void
.end method

.method public refreshHomeCard()V
    .locals 2

    .prologue
    .line 975
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "HomeTabFragment"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 976
    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v1, :cond_0

    .line 977
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->homeTabFragment:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 979
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->homeTabFragment:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    if-eqz v0, :cond_0

    .line 980
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->homeTabFragment:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    .line 981
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 982
    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeFragment;

    if-eqz v1, :cond_0

    .line 983
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getFragments()Ljava/util/List;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    .line 984
    if-eqz v0, :cond_0

    .line 985
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    .line 986
    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentTransaction;->detach(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 987
    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentTransaction;->attach(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 992
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 997
    :cond_0
    return-void
.end method

.method public replaceFragment(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 1845
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 1846
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 1847
    invoke-virtual {v0, p1, p2, p3}, Landroid/support/v4/app/FragmentTransaction;->replace(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 1848
    invoke-virtual {v0, p3}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 1849
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 1850
    return-void
.end method

.method public sendActivateLayout(Landroid/widget/RelativeLayout;)V
    .locals 0

    .prologue
    .line 1516
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->activateBanner:Landroid/widget/RelativeLayout;

    .line 1517
    return-void
.end method

.method public sendRecommendations(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 607
    new-instance v0, Lht;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->recommendations:Lmq;

    invoke-direct {v0, p0, v1, p1}, Lht;-><init>(Landroid/app/Activity;Lmq;Ljava/lang/String;)V

    .line 608
    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lht;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 609
    return-void
.end method

.method public sendRecommendations(Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V
    .locals 6

    .prologue
    .line 617
    new-instance v0, Lht;

    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->recommendations:Lmq;

    move-object v1, p0

    move-object v3, p1

    move-object v4, p2

    move-object v5, p3

    invoke-direct/range {v0 .. v5}, Lht;-><init>(Landroid/app/Activity;Lmq;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    .line 618
    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lht;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 619
    return-void
.end method

.method public sendRecommendations(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 612
    new-instance v0, Lht;

    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->recommendations:Lmq;

    move-object v1, p0

    move-object v3, p1

    move-object v4, p2

    move-object v5, p3

    invoke-direct/range {v0 .. v5}, Lht;-><init>(Landroid/app/Activity;Lmq;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 613
    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lht;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 614
    return-void
.end method

.method public sendRecommendations(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V
    .locals 7

    .prologue
    .line 622
    new-instance v0, Lht;

    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->recommendations:Lmq;

    move-object v1, p0

    move-object v3, p1

    move-object v4, p2

    move-object v5, p3

    move-object v6, p4

    invoke-direct/range {v0 .. v6}, Lht;-><init>(Landroid/app/Activity;Lmq;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    .line 623
    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lht;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 624
    return-void
.end method

.method public setAddToVisible(Z)V
    .locals 2

    .prologue
    .line 729
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->addToItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 730
    if-eqz p1, :cond_1

    .line 731
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->addToItem:Landroid/view/MenuItem;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 735
    :cond_0
    :goto_0
    return-void

    .line 733
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->addToItem:Landroid/view/MenuItem;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    goto :goto_0
.end method

.method public setCheckedStatus()V
    .locals 5

    .prologue
    const/4 v2, 0x0

    .line 701
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "show_availability"

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    .line 702
    invoke-direct {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->isGPSEnabled()Z

    move-result v1

    if-nez v1, :cond_1

    move v1, v2

    .line 705
    :goto_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v3, 0x7f020014

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/StateListDrawable;

    .line 706
    const/4 v3, 0x1

    new-array v4, v3, [I

    if-eqz v1, :cond_0

    const v3, 0x10100a0

    :goto_1
    aput v3, v4, v2

    .line 707
    invoke-virtual {v0, v4}, Landroid/graphics/drawable/StateListDrawable;->setState([I)Z

    .line 708
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->storeAvailability:Landroid/view/MenuItem;

    invoke-virtual {v0}, Landroid/graphics/drawable/StateListDrawable;->getCurrent()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-interface {v2, v0}, Landroid/view/MenuItem;->setIcon(Landroid/graphics/drawable/Drawable;)Landroid/view/MenuItem;

    .line 709
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->storeAvailability:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setChecked(Z)Landroid/view/MenuItem;

    .line 710
    return-void

    .line 706
    :cond_0
    const v3, 0x10100a9

    goto :goto_1

    :cond_1
    move v1, v0

    goto :goto_0
.end method

.method public setClearVisible(Z)V
    .locals 2

    .prologue
    .line 738
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->clearReviewsItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 739
    if-eqz p1, :cond_1

    .line 740
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->clearReviewsItem:Landroid/view/MenuItem;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 744
    :cond_0
    :goto_0
    return-void

    .line 742
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->clearReviewsItem:Landroid/view/MenuItem;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    goto :goto_0
.end method

.method public setMyBBYSection(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 1595
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->myBBYMenuItemView:Landroid/view/View;

    .line 1596
    return-void
.end method

.method public setNavigationModeForActivity()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 1857
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setNavigationMode(I)V

    .line 1858
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setDisplayShowHomeEnabled(Z)V

    .line 1859
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setDisplayShowTitleEnabled(Z)V

    .line 1860
    return-void
.end method

.method public setOnActionIconClickListener(Lcf;)V
    .locals 0

    .prologue
    .line 829
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->actionIconClickListener:Lcf;

    .line 830
    return-void
.end method

.method public setOnClearReviewsListener(Lcj;)V
    .locals 0

    .prologue
    .line 1511
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->clearReviewsClickListener:Lcj;

    .line 1512
    return-void
.end method

.method public setOnDNMSearchListener(Lcd;)V
    .locals 0

    .prologue
    .line 1569
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->onDNMSearchListener:Lcd;

    .line 1570
    return-void
.end method

.method public setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V
    .locals 5

    .prologue
    const/16 v4, 0x8

    const v3, 0x7f0c0150

    .line 1490
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->lifeEventsMenuItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_2

    .line 1491
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->lifeEventsMenuItem:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 1492
    if-eqz p3, :cond_3

    .line 1493
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->lifeEventsNavigationListener:Lcg;

    .line 1494
    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getVisibility()I

    move-result v1

    const/4 v2, 0x4

    if-eq v1, v2, :cond_0

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getVisibility()I

    move-result v1

    if-ne v1, v4, :cond_1

    .line 1496
    :cond_0
    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 1498
    :cond_1
    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, p2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 1499
    iput-object p2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->lifeEventsMenuItemTitle:Ljava/lang/String;

    .line 1501
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->lifeEventsMenuItem:Landroid/view/MenuItem;

    invoke-interface {v0, p3}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1508
    :cond_2
    :goto_0
    return-void

    .line 1504
    :cond_3
    invoke-interface {p0}, Lcv;->onCreateWishListFragmentExit()V

    .line 1505
    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public setOnListIdSearchClickListener(Lch;)V
    .locals 0

    .prologue
    .line 837
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchIconClickListener:Lch;

    .line 838
    return-void
.end method

.method public setOnStoreAvailabiltyClickListener(Lci;)V
    .locals 0

    .prologue
    .line 833
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->storeAvailabiltyClickListener:Lci;

    .line 834
    return-void
.end method

.method public setSearchAndQueryVisible(ZLjava/lang/String;)V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 717
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 718
    if-eqz p1, :cond_1

    .line 719
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 720
    iput-object p2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->query:Ljava/lang/String;

    .line 721
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->isFromPLPFragment:Z

    .line 726
    :cond_0
    :goto_0
    return-void

    .line 723
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    goto :goto_0
.end method

.method public setSearchVisible(Z)V
    .locals 2

    .prologue
    .line 683
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 684
    if-eqz p1, :cond_1

    .line 685
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 690
    :cond_0
    :goto_0
    return-void

    .line 687
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    goto :goto_0
.end method

.method public setShareURL(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1485
    sput-object p1, Lcom/bestbuy/android/activities/home/HomeActivity;->productShareURL:Ljava/lang/String;

    .line 1486
    return-void
.end method

.method public setShareVisible(Z)V
    .locals 2

    .prologue
    .line 673
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->shareItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 674
    if-eqz p1, :cond_1

    .line 675
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->shareItem:Landroid/view/MenuItem;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 680
    :cond_0
    :goto_0
    return-void

    .line 677
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->shareItem:Landroid/view/MenuItem;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    goto :goto_0
.end method

.method public setStoreAvailabilityVisible(Z)V
    .locals 1

    .prologue
    .line 694
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->storeAvailability:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 695
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->storeAvailability:Landroid/view/MenuItem;

    invoke-interface {v0, p1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 697
    :cond_0
    return-void
.end method

.method public showErrorBanner(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 1661
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 1662
    const-string v1, "bb.failedSearchTerm"

    invoke-virtual {v0, v1, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1663
    const-string v1, "bb.numResults"

    const-string v2, "zero"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1664
    sget-object v1, Llu;->bo:Ljava/lang/String;

    const-string v2, "browse,list,search,failed"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1665
    sget-object v1, Llu;->bp:Ljava/lang/String;

    const-string v2, "SRCL"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1666
    sget-object v1, Llu;->d:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 1668
    const v0, 0x7f0c0034

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 1669
    const v1, 0x7f0c0131

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "We couldn\'t find any matches for: \n \""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 1670
    const v1, 0x7f0c0132

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->tipsString:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 1671
    invoke-static {v0}, Lll;->b(Landroid/view/View;)V

    .line 1672
    return-void
.end method

.method public showMyBBYData()V
    .locals 6

    .prologue
    const/16 v5, 0x14

    .line 1599
    invoke-static {}, Lfr;->e()Ljava/lang/String;

    move-result-object v2

    .line 1600
    invoke-static {}, Lfr;->h()Ljava/lang/String;

    .line 1601
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->myBBYMenuItemView:Landroid/view/View;

    const v1, 0x7f0c0139

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 1602
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->myBBYMenuItemView:Landroid/view/View;

    const v3, 0x7f0c0137

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 1605
    if-eqz v2, :cond_0

    .line 1606
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v3

    if-lt v3, v5, :cond_2

    .line 1607
    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 1608
    invoke-virtual {v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setSingleLine()V

    .line 1609
    sget-object v3, Landroid/text/TextUtils$TruncateAt;->MARQUEE:Landroid/text/TextUtils$TruncateAt;

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V

    .line 1610
    invoke-virtual {v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v3

    .line 1611
    new-instance v4, Lcom/bestbuy/android/activities/home/HomeActivity$8;

    invoke-direct {v4, p0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity$8;-><init>(Lcom/bestbuy/android/activities/home/HomeActivity;Lcom/bestbuy/android/bbyobjects/BBYTextView;)V

    invoke-virtual {v3, v4}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 1638
    :cond_0
    :goto_0
    const v3, 0x7f02012a

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 1640
    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 1641
    invoke-virtual {v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->length()I

    move-result v0

    if-le v0, v5, :cond_1

    .line 1642
    invoke-virtual {v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setSingleLine()V

    .line 1643
    sget-object v0, Landroid/text/TextUtils$TruncateAt;->MARQUEE:Landroid/text/TextUtils$TruncateAt;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V

    .line 1647
    :cond_1
    return-void

    .line 1627
    :cond_2
    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 1628
    invoke-virtual {v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setSingleLine()V

    .line 1629
    sget-object v3, Landroid/text/TextUtils$TruncateAt;->MARQUEE:Landroid/text/TextUtils$TruncateAt;

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V

    goto :goto_0
.end method

.method public showNotification(Landroid/os/Bundle;)V
    .locals 10

    .prologue
    const/4 v2, 0x0

    const v9, 0x7f0c0033

    const v4, 0x7f080055

    const/4 v8, 0x0

    const/4 v7, 0x1

    .line 1977
    if-eqz p1, :cond_0

    const-string v0, "IS_CALLED_FROM_NOTIFICATION"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1978
    const-string v0, "IS_CALLED_FROM_NOTIFICATION"

    invoke-virtual {p1, v0, v8}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->isFromNotification:Z

    .line 1979
    const-string v0, "TAB_NAME"

    const-string v1, ""

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 1981
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 1982
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    .line 1984
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v0}, Landroid/support/v4/widget/DrawerLayout;->closeDrawers()V

    .line 1985
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->isFromNotification:Z

    if-eqz v0, :cond_0

    .line 1986
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v4

    .line 1987
    invoke-virtual {v4, v9}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 1988
    instance-of v5, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v5, :cond_2

    .line 1990
    const-string v2, "ProductTab"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1991
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 1992
    const-string v2, "MdotWebFragment"

    invoke-static {v2}, Lkb;->a(Ljava/lang/String;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v2

    .line 1993
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 1994
    const-string v4, "mDotURL"

    invoke-virtual {v3, v4, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1995
    const-string v1, "IS_DOD"

    invoke-virtual {v3, v1, v7}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1996
    invoke-virtual {v2, v3}, Landroid/support/v4/app/Fragment;->setArguments(Landroid/os/Bundle;)V

    .line 1997
    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0, v2, v7}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 2001
    :goto_1
    iput-boolean v8, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->isFromNotification:Z

    .line 2019
    :cond_0
    :goto_2
    return-void

    .line 1999
    :cond_1
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->a(I)V

    goto :goto_1

    .line 2003
    :cond_2
    new-instance v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v0, v7, v7}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>(ZZ)V

    .line 2004
    new-instance v5, Landroid/os/Bundle;

    invoke-direct {v5}, Landroid/os/Bundle;-><init>()V

    .line 2005
    const-string v6, "mDotURL"

    invoke-virtual {v5, v6, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 2006
    const-string v1, "ProductTab"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 2007
    const-string v1, "IS_DOD"

    invoke-virtual {v5, v1, v7}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 2009
    :cond_3
    invoke-virtual {v0, v5}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 2010
    invoke-virtual {v4}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    .line 2011
    const-string v3, "MdotWebFragment"

    invoke-virtual {v1, v9, v0, v3}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 2012
    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 2013
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 2014
    iput-boolean v8, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->isFromNotification:Z

    goto :goto_2

    :cond_4
    move-object v1, v2

    goto :goto_0
.end method

.method public showPopup()V
    .locals 1

    .prologue
    .line 577
    new-instance v0, Llj;

    invoke-direct {v0, p0}, Llj;-><init>(Landroid/content/Context;)V

    .line 578
    invoke-virtual {v0}, Llj;->show()V

    .line 586
    return-void
.end method

.method public showWishListData(Ljava/util/ArrayList;Ljava/lang/String;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v5, 0x1

    const v4, 0x7f0c0033

    .line 1918
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->wishListData:Ljava/util/List;

    if-nez v0, :cond_0

    .line 1919
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->wishListData:Ljava/util/List;

    .line 1924
    :goto_0
    const/4 v0, 0x0

    move v1, v0

    :goto_1
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_2

    .line 1925
    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 1926
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v2

    const-string v3, "weddingregistrylists"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 1927
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->wishListData:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1924
    :goto_2
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_1

    .line 1921
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->wishListData:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto :goto_0

    .line 1929
    :cond_1
    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->registryData:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    goto :goto_2

    .line 1932
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->wishListData:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 1938
    if-eqz p2, :cond_4

    if-eqz p2, :cond_3

    const-string v0, "wishlist"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->wishListData:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-gtz v0, :cond_4

    :cond_3
    if-eqz p2, :cond_6

    const-string v0, "weddingregistry"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->registryData:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    if-eqz v0, :cond_6

    .line 1939
    :cond_4
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 1940
    invoke-virtual {v0, v4}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 1941
    invoke-static {}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->e()Ljava/util/HashMap;

    move-result-object v1

    .line 1942
    const-string v2, "WishListData"

    iget-object v3, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->wishListData:Ljava/util/List;

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1943
    const-string v2, "RegistryData"

    iget-object v3, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->registryData:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1944
    const-string v2, "RegistryName"

    invoke-static {}, Lfr;->k()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1945
    const-string v2, "WishListData"

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_5

    .line 1946
    new-instance v2, Lla;

    invoke-direct {v2, p0, v0, v1}, Lla;-><init>(Landroid/content/Context;Landroid/support/v4/app/Fragment;Ljava/util/HashMap;)V

    .line 1947
    invoke-virtual {v2}, Lla;->show()V

    .line 1974
    :cond_5
    :goto_3
    return-void

    .line 1950
    :cond_6
    const-string v0, "wishlist"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 1951
    new-instance v1, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;

    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->ab()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v5, v0}, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;-><init>(ZLjava/lang/String;)V

    .line 1953
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 1954
    instance-of v2, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v2, :cond_7

    .line 1955
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 1956
    instance-of v0, v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    if-eqz v0, :cond_5

    .line 1958
    const-string v0, "WishListFragmentContainer"

    invoke-virtual {p0, v4, v1, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->addFragment(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)V

    goto :goto_3

    .line 1959
    :cond_7
    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    if-eqz v0, :cond_5

    .line 1960
    const-string v0, "WishListFragmentContainer"

    invoke-virtual {p0, v4, v1, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->addFragment(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)V

    goto :goto_3

    .line 1962
    :cond_8
    const-string v0, "weddingregistry"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 1963
    new-instance v1, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->ab()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v5, v0}, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;-><init>(ZLjava/lang/String;)V

    .line 1964
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 1965
    instance-of v2, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v2, :cond_9

    .line 1966
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 1967
    instance-of v0, v0, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    if-eqz v0, :cond_5

    .line 1968
    const-string v0, "RegistryFragmentContainer"

    invoke-virtual {p0, v4, v1, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->addFragment(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)V

    goto :goto_3

    .line 1969
    :cond_9
    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    if-eqz v0, :cond_5

    .line 1970
    const-string v0, "RegistryFragmentContainer"

    invoke-virtual {p0, v4, v1, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->addFragment(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)V

    goto :goto_3
.end method

.method public updateActionBarTitle(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 298
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->actionBarTitle:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    if-eqz v0, :cond_0

    .line 299
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->actionBarTitle:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 301
    :cond_0
    return-void
.end method

.method public updateSearchHint(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 647
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;->searchView:Landroid/widget/SearchView;

    invoke-virtual {v0, p1}, Landroid/widget/SearchView;->setQueryHint(Ljava/lang/CharSequence;)V

    .line 648
    return-void
.end method
