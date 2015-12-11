.class public Lcom/amazon/mShop/history/HistoryEntity;
.super Ljava/lang/Object;
.source "HistoryEntity.java"


# static fields
.field public static final HISTORY_PROJECTION:[Ljava/lang/String;

.field public static final HISTORY_VISION_PROJECTION:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 13
    new-array v0, v5, [Ljava/lang/String;

    const-string/jumbo v1, "_id"

    aput-object v1, v0, v2

    const-string/jumbo v1, "asin"

    aput-object v1, v0, v3

    const-string/jumbo v1, "visit_date"

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/mShop/history/HistoryEntity;->HISTORY_PROJECTION:[Ljava/lang/String;

    .line 19
    new-array v0, v5, [Ljava/lang/String;

    const-string/jumbo v1, "asin"

    aput-object v1, v0, v2

    const-string/jumbo v1, "visit_date"

    aput-object v1, v0, v3

    const-string/jumbo v1, "original_scanned_history"

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/mShop/history/HistoryEntity;->HISTORY_VISION_PROJECTION:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    return-void
.end method
