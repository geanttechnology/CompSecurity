.class public final enum Lcom/adobe/mediacore/metadata/AdSignalingMode;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/mediacore/metadata/AdSignalingMode;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/mediacore/metadata/AdSignalingMode;

.field public static final enum CUSTOM_TIME_RANGES:Lcom/adobe/mediacore/metadata/AdSignalingMode;

.field public static final enum DEFAULT:Lcom/adobe/mediacore/metadata/AdSignalingMode;

.field public static final enum MANIFEST_CUES:Lcom/adobe/mediacore/metadata/AdSignalingMode;

.field public static final enum SERVER_MAP:Lcom/adobe/mediacore/metadata/AdSignalingMode;


# instance fields
.field private _value:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    new-instance v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;

    const-string v1, "DEFAULT"

    const-string v2, "default"

    invoke-direct {v0, v1, v3, v2}, Lcom/adobe/mediacore/metadata/AdSignalingMode;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->DEFAULT:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    new-instance v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;

    const-string v1, "MANIFEST_CUES"

    const-string v2, "manifest cues"

    invoke-direct {v0, v1, v4, v2}, Lcom/adobe/mediacore/metadata/AdSignalingMode;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->MANIFEST_CUES:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    new-instance v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;

    const-string v1, "SERVER_MAP"

    const-string v2, "server map"

    invoke-direct {v0, v1, v5, v2}, Lcom/adobe/mediacore/metadata/AdSignalingMode;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->SERVER_MAP:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    new-instance v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;

    const-string v1, "CUSTOM_TIME_RANGES"

    const-string v2, "custom time ranges"

    invoke-direct {v0, v1, v6, v2}, Lcom/adobe/mediacore/metadata/AdSignalingMode;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->CUSTOM_TIME_RANGES:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    const/4 v0, 0x4

    new-array v0, v0, [Lcom/adobe/mediacore/metadata/AdSignalingMode;

    sget-object v1, Lcom/adobe/mediacore/metadata/AdSignalingMode;->DEFAULT:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    aput-object v1, v0, v3

    sget-object v1, Lcom/adobe/mediacore/metadata/AdSignalingMode;->MANIFEST_CUES:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    aput-object v1, v0, v4

    sget-object v1, Lcom/adobe/mediacore/metadata/AdSignalingMode;->SERVER_MAP:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    aput-object v1, v0, v5

    sget-object v1, Lcom/adobe/mediacore/metadata/AdSignalingMode;->CUSTOM_TIME_RANGES:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    aput-object v1, v0, v6

    sput-object v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->$VALUES:[Lcom/adobe/mediacore/metadata/AdSignalingMode;

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

    iput-object p3, p0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->_value:Ljava/lang/String;

    return-void
.end method

.method public static createFrom(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/AdSignalingMode;
    .locals 5

    invoke-static {}, Lcom/adobe/mediacore/metadata/AdSignalingMode;->values()[Lcom/adobe/mediacore/metadata/AdSignalingMode;

    move-result-object v2

    array-length v3, v2

    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v0, v2, v1

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/AdSignalingMode;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    :goto_1
    return-object v0

    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    :cond_1
    sget-object v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->DEFAULT:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/AdSignalingMode;
    .locals 1

    const-class v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;

    return-object v0
.end method

.method public static values()[Lcom/adobe/mediacore/metadata/AdSignalingMode;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->$VALUES:[Lcom/adobe/mediacore/metadata/AdSignalingMode;

    invoke-virtual {v0}, [Lcom/adobe/mediacore/metadata/AdSignalingMode;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/mediacore/metadata/AdSignalingMode;

    return-object v0
.end method


# virtual methods
.method public getValue()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->_value:Ljava/lang/String;

    return-object v0
.end method
