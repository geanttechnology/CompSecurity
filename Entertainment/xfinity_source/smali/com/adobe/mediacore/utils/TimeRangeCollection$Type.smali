.class public final enum Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/utils/TimeRangeCollection;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Type"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;

.field public static final enum DELETE_RANGES:Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;

.field public static final enum MARK_RANGES:Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;

.field public static final enum REPLACE_RANGES:Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;


# instance fields
.field private final _value:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    new-instance v0, Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;

    const-string v1, "DELETE_RANGES"

    const-string v2, "delete_ranges"

    invoke-direct {v0, v1, v3, v2}, Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;->DELETE_RANGES:Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;

    new-instance v0, Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;

    const-string v1, "REPLACE_RANGES"

    const-string v2, "replace_ranges"

    invoke-direct {v0, v1, v4, v2}, Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;->REPLACE_RANGES:Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;

    new-instance v0, Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;

    const-string v1, "MARK_RANGES"

    const-string v2, "mark_ranges"

    invoke-direct {v0, v1, v5, v2}, Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;->MARK_RANGES:Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;

    const/4 v0, 0x3

    new-array v0, v0, [Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;

    sget-object v1, Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;->DELETE_RANGES:Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;

    aput-object v1, v0, v3

    sget-object v1, Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;->REPLACE_RANGES:Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;

    aput-object v1, v0, v4

    sget-object v1, Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;->MARK_RANGES:Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;

    aput-object v1, v0, v5

    sput-object v0, Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;->$VALUES:[Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    iput-object p3, p0, Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;->_value:Ljava/lang/String;

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;
    .locals 1

    const-class v0, Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;

    return-object v0
.end method

.method public static values()[Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;->$VALUES:[Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;

    invoke-virtual {v0}, [Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;

    return-object v0
.end method


# virtual methods
.method public getValue()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;->_value:Ljava/lang/String;

    return-object v0
.end method
