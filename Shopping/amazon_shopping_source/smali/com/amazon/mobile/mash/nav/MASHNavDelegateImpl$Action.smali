.class final enum Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;
.super Ljava/lang/Enum;
.source "MASHNavDelegateImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "Action"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum add_on_interstitial:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum add_to_cart:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum add_to_wishlist:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum browse:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum browse_history:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum browser_view:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum buy_now:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum cancel_order:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum cart:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum checkout:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum deal_page:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum deals:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum detail:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum external:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum friend_app:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum go_back:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum home:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum image_gallery:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum login:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum logout:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum mobileads_user_preferences:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum more_buying_choices:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum one_click_settings:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum order_history:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum push_notification_settings:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum recommendations:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum scan_it:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum search:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum share:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum snap_it:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum track_order:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum update_cart:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum video:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum view_order:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum webview:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum wishlist:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

.field public static final enum your_account:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 24
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "scan_it"

    invoke-direct {v0, v1, v3}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->scan_it:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 25
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "snap_it"

    invoke-direct {v0, v1, v4}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->snap_it:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 26
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "add_to_cart"

    invoke-direct {v0, v1, v5}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->add_to_cart:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 27
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "cart"

    invoke-direct {v0, v1, v6}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->cart:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 28
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "add_to_wishlist"

    invoke-direct {v0, v1, v7}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->add_to_wishlist:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 29
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "wishlist"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->wishlist:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 30
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "checkout"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->checkout:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 31
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "buy_now"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->buy_now:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 32
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "detail"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->detail:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 33
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "deal_page"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->deal_page:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 34
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "browse"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->browse:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 35
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "browse_history"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->browse_history:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 36
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "search"

    const/16 v2, 0xc

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->search:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 37
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "your_account"

    const/16 v2, 0xd

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->your_account:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 38
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "order_history"

    const/16 v2, 0xe

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->order_history:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 39
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "cancel_order"

    const/16 v2, 0xf

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->cancel_order:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 40
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "view_order"

    const/16 v2, 0x10

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->view_order:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 41
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "track_order"

    const/16 v2, 0x11

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->track_order:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 42
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "one_click_settings"

    const/16 v2, 0x12

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->one_click_settings:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 43
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "recommendations"

    const/16 v2, 0x13

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->recommendations:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 44
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "deals"

    const/16 v2, 0x14

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->deals:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 45
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "login"

    const/16 v2, 0x15

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->login:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 46
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "logout"

    const/16 v2, 0x16

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->logout:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 47
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "video"

    const/16 v2, 0x17

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->video:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 48
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "image_gallery"

    const/16 v2, 0x18

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->image_gallery:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 49
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "external"

    const/16 v2, 0x19

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->external:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 50
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "share"

    const/16 v2, 0x1a

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->share:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 51
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "friend_app"

    const/16 v2, 0x1b

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->friend_app:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 52
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "home"

    const/16 v2, 0x1c

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->home:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 53
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "more_buying_choices"

    const/16 v2, 0x1d

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->more_buying_choices:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 54
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "add_on_interstitial"

    const/16 v2, 0x1e

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->add_on_interstitial:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 55
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "mobileads_user_preferences"

    const/16 v2, 0x1f

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->mobileads_user_preferences:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 56
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "webview"

    const/16 v2, 0x20

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->webview:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 57
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "browser_view"

    const/16 v2, 0x21

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->browser_view:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 58
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "update_cart"

    const/16 v2, 0x22

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->update_cart:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 59
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "go_back"

    const/16 v2, 0x23

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->go_back:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 60
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    const-string/jumbo v1, "push_notification_settings"

    const/16 v2, 0x24

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->push_notification_settings:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    .line 23
    const/16 v0, 0x25

    new-array v0, v0, [Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    sget-object v1, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->scan_it:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->snap_it:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->add_to_cart:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->cart:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->add_to_wishlist:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->wishlist:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->checkout:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->buy_now:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->detail:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->deal_page:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->browse:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->browse_history:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->search:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->your_account:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->order_history:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->cancel_order:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->view_order:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->track_order:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->one_click_settings:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->recommendations:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0x14

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->deals:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0x15

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->login:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0x16

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->logout:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0x17

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->video:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0x18

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->image_gallery:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0x19

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->external:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->share:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->friend_app:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->home:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->more_buying_choices:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->add_on_interstitial:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->mobileads_user_preferences:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0x20

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->webview:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0x21

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->browser_view:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0x22

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->update_cart:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0x23

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->go_back:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    const/16 v1, 0x24

    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->push_notification_settings:Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->$VALUES:[Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 23
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 23
    const-class v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;
    .locals 1

    .prologue
    .line 23
    sget-object v0, Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->$VALUES:[Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    invoke-virtual {v0}, [Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action;

    return-object v0
.end method
