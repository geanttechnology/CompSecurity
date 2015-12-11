.class public final enum Lcom/adobe/mediacore/logging/Logger$Verbosity;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/logging/Logger;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Verbosity"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/mediacore/logging/Logger$Verbosity;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/mediacore/logging/Logger$Verbosity;

.field public static final enum DEBUG:Lcom/adobe/mediacore/logging/Logger$Verbosity;

.field public static final enum ERROR:Lcom/adobe/mediacore/logging/Logger$Verbosity;

.field public static final enum INFO:Lcom/adobe/mediacore/logging/Logger$Verbosity;

.field public static final enum NONE:Lcom/adobe/mediacore/logging/Logger$Verbosity;

.field public static final enum WARN:Lcom/adobe/mediacore/logging/Logger$Verbosity;


# instance fields
.field private final level:I


# direct methods
.method static constructor <clinit>()V
    .locals 7

    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    new-instance v0, Lcom/adobe/mediacore/logging/Logger$Verbosity;

    const-string v1, "NONE"

    invoke-direct {v0, v1, v2, v2}, Lcom/adobe/mediacore/logging/Logger$Verbosity;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/mediacore/logging/Logger$Verbosity;->NONE:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    new-instance v0, Lcom/adobe/mediacore/logging/Logger$Verbosity;

    const-string v1, "ERROR"

    invoke-direct {v0, v1, v3, v3}, Lcom/adobe/mediacore/logging/Logger$Verbosity;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/mediacore/logging/Logger$Verbosity;->ERROR:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    new-instance v0, Lcom/adobe/mediacore/logging/Logger$Verbosity;

    const-string v1, "WARN"

    invoke-direct {v0, v1, v4, v4}, Lcom/adobe/mediacore/logging/Logger$Verbosity;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/mediacore/logging/Logger$Verbosity;->WARN:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    new-instance v0, Lcom/adobe/mediacore/logging/Logger$Verbosity;

    const-string v1, "INFO"

    invoke-direct {v0, v1, v5, v5}, Lcom/adobe/mediacore/logging/Logger$Verbosity;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/mediacore/logging/Logger$Verbosity;->INFO:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    new-instance v0, Lcom/adobe/mediacore/logging/Logger$Verbosity;

    const-string v1, "DEBUG"

    invoke-direct {v0, v1, v6, v6}, Lcom/adobe/mediacore/logging/Logger$Verbosity;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/mediacore/logging/Logger$Verbosity;->DEBUG:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    const/4 v0, 0x5

    new-array v0, v0, [Lcom/adobe/mediacore/logging/Logger$Verbosity;

    sget-object v1, Lcom/adobe/mediacore/logging/Logger$Verbosity;->NONE:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    aput-object v1, v0, v2

    sget-object v1, Lcom/adobe/mediacore/logging/Logger$Verbosity;->ERROR:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    aput-object v1, v0, v3

    sget-object v1, Lcom/adobe/mediacore/logging/Logger$Verbosity;->WARN:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    aput-object v1, v0, v4

    sget-object v1, Lcom/adobe/mediacore/logging/Logger$Verbosity;->INFO:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    aput-object v1, v0, v5

    sget-object v1, Lcom/adobe/mediacore/logging/Logger$Verbosity;->DEBUG:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    aput-object v1, v0, v6

    sput-object v0, Lcom/adobe/mediacore/logging/Logger$Verbosity;->$VALUES:[Lcom/adobe/mediacore/logging/Logger$Verbosity;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    iput p3, p0, Lcom/adobe/mediacore/logging/Logger$Verbosity;->level:I

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger$Verbosity;
    .locals 1

    const-class v0, Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/logging/Logger$Verbosity;

    return-object v0
.end method

.method public static values()[Lcom/adobe/mediacore/logging/Logger$Verbosity;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/logging/Logger$Verbosity;->$VALUES:[Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v0}, [Lcom/adobe/mediacore/logging/Logger$Verbosity;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/mediacore/logging/Logger$Verbosity;

    return-object v0
.end method


# virtual methods
.method public getLevel()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/logging/Logger$Verbosity;->level:I

    return v0
.end method
