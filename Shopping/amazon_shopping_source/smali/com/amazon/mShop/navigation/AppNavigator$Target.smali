.class public final enum Lcom/amazon/mShop/navigation/AppNavigator$Target;
.super Ljava/lang/Enum;
.source "AppNavigator.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/navigation/AppNavigator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Target"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/navigation/AppNavigator$Target;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum aiv_gateway:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum aiv_help:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum aiv_settings:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum aiv_webview:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum appstore_default:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum back_up_your_photos:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum change_country:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum charity:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum contact_us:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum deals:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum exit:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum gift_cards:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum help:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum home:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum login:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum logout:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum mas_all_categories:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum mas_best_sellers:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum mas_coins:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum mas_entertainment:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum mas_games:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum mas_gateway:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum mas_help:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum mas_new_releases:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum mas_recommended:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum mas_settings:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum mas_subscriptions:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum mas_your_apps:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum notifications:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum prime_upsell:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum shop_by_department:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum webview:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum your_account:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum your_orders:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum your_recently_viewed_items:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum your_recommendations:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum your_subscribe_and_save:Lcom/amazon/mShop/navigation/AppNavigator$Target;

.field public static final enum your_wish_list:Lcom/amazon/mShop/navigation/AppNavigator$Target;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 164
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "home"

    invoke-direct {v0, v1, v3}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->home:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 168
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "shop_by_department"

    invoke-direct {v0, v1, v4}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->shop_by_department:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 175
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "deals"

    invoke-direct {v0, v1, v5}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->deals:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 179
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "gift_cards"

    invoke-direct {v0, v1, v6}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->gift_cards:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 183
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "your_recently_viewed_items"

    invoke-direct {v0, v1, v7}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->your_recently_viewed_items:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 187
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "charity"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->charity:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 193
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "your_wish_list"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->your_wish_list:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 202
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "your_orders"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->your_orders:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 206
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "your_account"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->your_account:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 210
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "your_recommendations"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->your_recommendations:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 214
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "your_subscribe_and_save"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->your_subscribe_and_save:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 218
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "back_up_your_photos"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->back_up_your_photos:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 222
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "change_country"

    const/16 v2, 0xc

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->change_country:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 226
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "notifications"

    const/16 v2, 0xd

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->notifications:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 230
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "contact_us"

    const/16 v2, 0xe

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->contact_us:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 234
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "help"

    const/16 v2, 0xf

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->help:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 238
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "login"

    const/16 v2, 0x10

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->login:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 242
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "logout"

    const/16 v2, 0x11

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->logout:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 246
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "webview"

    const/16 v2, 0x12

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->webview:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 251
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "aiv_webview"

    const/16 v2, 0x13

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->aiv_webview:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 255
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "aiv_settings"

    const/16 v2, 0x14

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->aiv_settings:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 259
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "aiv_help"

    const/16 v2, 0x15

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->aiv_help:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 263
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "aiv_gateway"

    const/16 v2, 0x16

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->aiv_gateway:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 267
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "prime_upsell"

    const/16 v2, 0x17

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->prime_upsell:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 271
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "appstore_default"

    const/16 v2, 0x18

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->appstore_default:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 275
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "mas_gateway"

    const/16 v2, 0x19

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_gateway:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 279
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "mas_recommended"

    const/16 v2, 0x1a

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_recommended:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 283
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "mas_new_releases"

    const/16 v2, 0x1b

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_new_releases:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 287
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "mas_best_sellers"

    const/16 v2, 0x1c

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_best_sellers:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 291
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "mas_coins"

    const/16 v2, 0x1d

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_coins:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 295
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "mas_games"

    const/16 v2, 0x1e

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_games:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 299
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "mas_entertainment"

    const/16 v2, 0x1f

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_entertainment:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 303
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "mas_all_categories"

    const/16 v2, 0x20

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_all_categories:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 307
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "mas_your_apps"

    const/16 v2, 0x21

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_your_apps:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 311
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "mas_subscriptions"

    const/16 v2, 0x22

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_subscriptions:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 315
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "mas_settings"

    const/16 v2, 0x23

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_settings:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 319
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "mas_help"

    const/16 v2, 0x24

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_help:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 323
    new-instance v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v1, "exit"

    const/16 v2, 0x25

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator$Target;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->exit:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .line 160
    const/16 v0, 0x26

    new-array v0, v0, [Lcom/amazon/mShop/navigation/AppNavigator$Target;

    sget-object v1, Lcom/amazon/mShop/navigation/AppNavigator$Target;->home:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/mShop/navigation/AppNavigator$Target;->shop_by_department:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/mShop/navigation/AppNavigator$Target;->deals:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/mShop/navigation/AppNavigator$Target;->gift_cards:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/mShop/navigation/AppNavigator$Target;->your_recently_viewed_items:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->charity:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->your_wish_list:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->your_orders:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->your_account:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->your_recommendations:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->your_subscribe_and_save:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->back_up_your_photos:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->change_country:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->notifications:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->contact_us:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->help:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->login:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->logout:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->webview:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->aiv_webview:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0x14

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->aiv_settings:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0x15

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->aiv_help:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0x16

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->aiv_gateway:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0x17

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->prime_upsell:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0x18

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->appstore_default:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0x19

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_gateway:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_recommended:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_new_releases:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_best_sellers:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_coins:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_games:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_entertainment:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0x20

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_all_categories:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0x21

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_your_apps:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0x22

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_subscriptions:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0x23

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_settings:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0x24

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_help:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    const/16 v1, 0x25

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->exit:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->$VALUES:[Lcom/amazon/mShop/navigation/AppNavigator$Target;

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
    .line 160
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static from(Ljava/lang/String;)Lcom/amazon/mShop/navigation/AppNavigator$Target;
    .locals 4
    .param p0, "targetString"    # Ljava/lang/String;

    .prologue
    .line 333
    :try_start_0
    invoke-static {p0}, Lcom/amazon/mShop/navigation/AppNavigator$Target;->valueOf(Ljava/lang/String;)Lcom/amazon/mShop/navigation/AppNavigator$Target;
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v1

    .line 340
    :goto_0
    return-object v1

    .line 334
    :catch_0
    move-exception v0

    .line 335
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    # getter for: Lcom/amazon/mShop/navigation/AppNavigator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/navigation/AppNavigator;->access$000()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Unknown target : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 340
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    :goto_1
    const/4 v1, 0x0

    goto :goto_0

    .line 336
    :catch_1
    move-exception v0

    .line 337
    .local v0, "e":Ljava/lang/NullPointerException;
    # getter for: Lcom/amazon/mShop/navigation/AppNavigator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/navigation/AppNavigator;->access$000()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Unknown target : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/navigation/AppNavigator$Target;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 160
    const-class v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/navigation/AppNavigator$Target;
    .locals 1

    .prologue
    .line 160
    sget-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->$VALUES:[Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-virtual {v0}, [Lcom/amazon/mShop/navigation/AppNavigator$Target;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/navigation/AppNavigator$Target;

    return-object v0
.end method
