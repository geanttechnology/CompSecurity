.class public final enum Lcom/poshmark/utils/DateUtils$TIME_UNIT;
.super Ljava/lang/Enum;
.source "DateUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/DateUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "TIME_UNIT"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/utils/DateUtils$TIME_UNIT;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/utils/DateUtils$TIME_UNIT;

.field public static final enum DAYS:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

.field public static final enum HOURS:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

.field public static final enum MINUTES:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

.field public static final enum MONTHS:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

.field public static final enum SECONDS:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

.field public static final enum WEEKS:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

.field public static final enum YEARS:Lcom/poshmark/utils/DateUtils$TIME_UNIT;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 19
    new-instance v0, Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    const-string v1, "SECONDS"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/utils/DateUtils$TIME_UNIT;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DateUtils$TIME_UNIT;->SECONDS:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    new-instance v0, Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    const-string v1, "MINUTES"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/utils/DateUtils$TIME_UNIT;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DateUtils$TIME_UNIT;->MINUTES:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    new-instance v0, Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    const-string v1, "HOURS"

    invoke-direct {v0, v1, v5}, Lcom/poshmark/utils/DateUtils$TIME_UNIT;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DateUtils$TIME_UNIT;->HOURS:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    new-instance v0, Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    const-string v1, "DAYS"

    invoke-direct {v0, v1, v6}, Lcom/poshmark/utils/DateUtils$TIME_UNIT;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DateUtils$TIME_UNIT;->DAYS:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    new-instance v0, Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    const-string v1, "WEEKS"

    invoke-direct {v0, v1, v7}, Lcom/poshmark/utils/DateUtils$TIME_UNIT;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DateUtils$TIME_UNIT;->WEEKS:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    new-instance v0, Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    const-string v1, "MONTHS"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/DateUtils$TIME_UNIT;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DateUtils$TIME_UNIT;->MONTHS:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    new-instance v0, Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    const-string v1, "YEARS"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/DateUtils$TIME_UNIT;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DateUtils$TIME_UNIT;->YEARS:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    const/4 v0, 0x7

    new-array v0, v0, [Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    sget-object v1, Lcom/poshmark/utils/DateUtils$TIME_UNIT;->SECONDS:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/utils/DateUtils$TIME_UNIT;->MINUTES:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    aput-object v1, v0, v4

    sget-object v1, Lcom/poshmark/utils/DateUtils$TIME_UNIT;->HOURS:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    aput-object v1, v0, v5

    sget-object v1, Lcom/poshmark/utils/DateUtils$TIME_UNIT;->DAYS:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    aput-object v1, v0, v6

    sget-object v1, Lcom/poshmark/utils/DateUtils$TIME_UNIT;->WEEKS:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/poshmark/utils/DateUtils$TIME_UNIT;->MONTHS:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/poshmark/utils/DateUtils$TIME_UNIT;->YEARS:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    aput-object v2, v0, v1

    sput-object v0, Lcom/poshmark/utils/DateUtils$TIME_UNIT;->$VALUES:[Lcom/poshmark/utils/DateUtils$TIME_UNIT;

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
    .line 19
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/utils/DateUtils$TIME_UNIT;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 19
    const-class v0, Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/utils/DateUtils$TIME_UNIT;
    .locals 1

    .prologue
    .line 19
    sget-object v0, Lcom/poshmark/utils/DateUtils$TIME_UNIT;->$VALUES:[Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    invoke-virtual {v0}, [Lcom/poshmark/utils/DateUtils$TIME_UNIT;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    return-object v0
.end method
