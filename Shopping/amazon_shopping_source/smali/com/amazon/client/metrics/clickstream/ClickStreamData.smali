.class public final enum Lcom/amazon/client/metrics/clickstream/ClickStreamData;
.super Ljava/lang/Enum;
.source "ClickStreamData.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/client/metrics/clickstream/ClickStreamData;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum COUNTRY_OF_RESIDENCE:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum CUSTOMER_ID:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum DEVICE_TYPE_ID:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum ECOMMERCE_PAGE_ACTION:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum END_TIME:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum GROUPING_ASIN:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum HIT_TYPE:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum IMPRESSION_DATA:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum IMPRESSION_METADATA:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum IMPRESSION_PROGRAM_GROUP:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum IMPRESSION_TYPE:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum INFO:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum IP_ADDRESS:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum IS_CUSTOMER_HIT:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum IS_GLANCE_VIEW:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum IS_PRIME_CUSTOMER:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum IS_PRIME_ELIGIBLE_ITEM:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum MARKETPLACE:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum MARKETPLACE_ID:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum ORDER_DATA:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum PAGE_ACTION:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum PAGE_ASSEMBLY_TYPE:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum PAGE_TYPE:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum PAGE_TYPE_ID:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum PRODUCT_GLID:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum REQUEST_ID:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum SESSION_ID:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum SITE_VARIANT:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum START_TIME:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum SUB_PAGE_TYPE:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum TAB_ID:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum TEAM_NAME:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

.field public static final enum USER_AGENT:Lcom/amazon/client/metrics/clickstream/ClickStreamData;


# instance fields
.field private final mName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 15
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "REQUEST_ID"

    const-string/jumbo v2, "RequestId"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->REQUEST_ID:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 16
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "SESSION_ID"

    const-string/jumbo v2, "Session"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->SESSION_ID:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 17
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "CUSTOMER_ID"

    const-string/jumbo v2, "CustomerId"

    invoke-direct {v0, v1, v6, v2}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->CUSTOMER_ID:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 18
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "END_TIME"

    const-string/jumbo v2, "EndTime"

    invoke-direct {v0, v1, v7, v2}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->END_TIME:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 19
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "START_TIME"

    const-string/jumbo v2, "StartTime"

    invoke-direct {v0, v1, v8, v2}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->START_TIME:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 20
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "IP_ADDRESS"

    const/4 v2, 0x5

    const-string/jumbo v3, "REMOTE_ADDR"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->IP_ADDRESS:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 21
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "USER_AGENT"

    const/4 v2, 0x6

    const-string/jumbo v3, "HTTP_USER_AGENT"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->USER_AGENT:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 22
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "MARKETPLACE_ID"

    const/4 v2, 0x7

    const-string/jumbo v3, "Marketplaceid"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->MARKETPLACE_ID:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 23
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "MARKETPLACE"

    const/16 v2, 0x8

    const-string/jumbo v3, "Marketplace"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->MARKETPLACE:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 24
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "DEVICE_TYPE_ID"

    const/16 v2, 0x9

    const-string/jumbo v3, "deviceTypeID"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->DEVICE_TYPE_ID:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 25
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "INFO"

    const/16 v2, 0xa

    const-string/jumbo v3, "Info"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->INFO:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 26
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "COUNTRY_OF_RESIDENCE"

    const/16 v2, 0xb

    const-string/jumbo v3, "cor"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->COUNTRY_OF_RESIDENCE:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 32
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "PAGE_TYPE"

    const/16 v2, 0xc

    const-string/jumbo v3, "page-type"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->PAGE_TYPE:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 33
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "HIT_TYPE"

    const/16 v2, 0xd

    const-string/jumbo v3, "hitType"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->HIT_TYPE:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 34
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "TEAM_NAME"

    const/16 v2, 0xe

    const-string/jumbo v3, "team-name"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->TEAM_NAME:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 35
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "SITE_VARIANT"

    const/16 v2, 0xf

    const-string/jumbo v3, "site-variant"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->SITE_VARIANT:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 37
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "PAGE_ACTION"

    const/16 v2, 0x10

    const-string/jumbo v3, "page-action"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->PAGE_ACTION:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 38
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "SUB_PAGE_TYPE"

    const/16 v2, 0x11

    const-string/jumbo v3, "sub-page-type"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->SUB_PAGE_TYPE:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 39
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "PAGE_TYPE_ID"

    const/16 v2, 0x12

    const-string/jumbo v3, "page-type-id"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->PAGE_TYPE_ID:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 40
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "TAB_ID"

    const/16 v2, 0x13

    const-string/jumbo v3, "tab-id"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->TAB_ID:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 41
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "PAGE_ASSEMBLY_TYPE"

    const/16 v2, 0x14

    const-string/jumbo v3, "pageAssemblyType"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->PAGE_ASSEMBLY_TYPE:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 42
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "IS_CUSTOMER_HIT"

    const/16 v2, 0x15

    const-string/jumbo v3, "is-customer-hit"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->IS_CUSTOMER_HIT:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 43
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "IS_PRIME_CUSTOMER"

    const/16 v2, 0x16

    const-string/jumbo v3, "is-prime-customer"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->IS_PRIME_CUSTOMER:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 45
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "GROUPING_ASIN"

    const/16 v2, 0x17

    const-string/jumbo v3, "groupingAsin"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->GROUPING_ASIN:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 46
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "PRODUCT_GLID"

    const/16 v2, 0x18

    const-string/jumbo v3, "productGLID"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->PRODUCT_GLID:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 52
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "ECOMMERCE_PAGE_ACTION"

    const/16 v2, 0x19

    const-string/jumbo v3, "ecommerce-page-action"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->ECOMMERCE_PAGE_ACTION:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 53
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "ORDER_DATA"

    const/16 v2, 0x1a

    const-string/jumbo v3, "order-data"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->ORDER_DATA:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 55
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "IS_PRIME_ELIGIBLE_ITEM"

    const/16 v2, 0x1b

    const-string/jumbo v3, "is-prime-eligible-item"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->IS_PRIME_ELIGIBLE_ITEM:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 56
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "IS_GLANCE_VIEW"

    const/16 v2, 0x1c

    const-string/jumbo v3, "is-glance-view"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->IS_GLANCE_VIEW:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 61
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "IMPRESSION_PROGRAM_GROUP"

    const/16 v2, 0x1d

    const-string/jumbo v3, "programGroup"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->IMPRESSION_PROGRAM_GROUP:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 62
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "IMPRESSION_TYPE"

    const/16 v2, 0x1e

    const-string/jumbo v3, "impressionType"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->IMPRESSION_TYPE:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 63
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "IMPRESSION_DATA"

    const/16 v2, 0x1f

    const-string/jumbo v3, "impressionData"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->IMPRESSION_DATA:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 64
    new-instance v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    const-string/jumbo v1, "IMPRESSION_METADATA"

    const/16 v2, 0x20

    const-string/jumbo v3, "impressionMetadata"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->IMPRESSION_METADATA:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    .line 11
    const/16 v0, 0x21

    new-array v0, v0, [Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    sget-object v1, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->REQUEST_ID:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->SESSION_ID:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->CUSTOMER_ID:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->END_TIME:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->START_TIME:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->IP_ADDRESS:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->USER_AGENT:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->MARKETPLACE_ID:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->MARKETPLACE:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->DEVICE_TYPE_ID:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->INFO:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->COUNTRY_OF_RESIDENCE:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->PAGE_TYPE:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->HIT_TYPE:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->TEAM_NAME:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->SITE_VARIANT:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->PAGE_ACTION:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->SUB_PAGE_TYPE:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->PAGE_TYPE_ID:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->TAB_ID:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/16 v1, 0x14

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->PAGE_ASSEMBLY_TYPE:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/16 v1, 0x15

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->IS_CUSTOMER_HIT:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/16 v1, 0x16

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->IS_PRIME_CUSTOMER:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/16 v1, 0x17

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->GROUPING_ASIN:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/16 v1, 0x18

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->PRODUCT_GLID:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/16 v1, 0x19

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->ECOMMERCE_PAGE_ACTION:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->ORDER_DATA:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->IS_PRIME_ELIGIBLE_ITEM:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->IS_GLANCE_VIEW:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->IMPRESSION_PROGRAM_GROUP:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->IMPRESSION_TYPE:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->IMPRESSION_DATA:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    const/16 v1, 0x20

    sget-object v2, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->IMPRESSION_METADATA:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->$VALUES:[Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 72
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 73
    iput-object p3, p0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->mName:Ljava/lang/String;

    .line 74
    return-void
.end method

.method public static fromString(Ljava/lang/String;)Lcom/amazon/client/metrics/clickstream/ClickStreamData;
    .locals 7
    .param p0, "str"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/client/metrics/MetricsException;
        }
    .end annotation

    .prologue
    .line 77
    invoke-static {}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->values()[Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/client/metrics/clickstream/ClickStreamData;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v3, v0, v1

    .line 78
    .local v3, "value":Lcom/amazon/client/metrics/clickstream/ClickStreamData;
    invoke-virtual {v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 79
    return-object v3

    .line 77
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 82
    .end local v3    # "value":Lcom/amazon/client/metrics/clickstream/ClickStreamData;
    :cond_1
    new-instance v4, Lcom/amazon/client/metrics/MetricsException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, " is not a valid ClickStreamData"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lcom/amazon/client/metrics/MetricsException;-><init>(Ljava/lang/String;)V

    throw v4
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/client/metrics/clickstream/ClickStreamData;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    return-object v0
.end method

.method public static values()[Lcom/amazon/client/metrics/clickstream/ClickStreamData;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->$VALUES:[Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    invoke-virtual {v0}, [Lcom/amazon/client/metrics/clickstream/ClickStreamData;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    return-object v0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->mName:Ljava/lang/String;

    return-object v0
.end method
