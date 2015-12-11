.class public final enum Lcom/adobe/ave/UpdateType;
.super Ljava/lang/Enum;
.source "UpdateType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/ave/UpdateType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/ave/UpdateType;

.field public static final enum BACKGROUND:Lcom/adobe/ave/UpdateType;

.field public static final enum CAPTION_ACTIVITY:Lcom/adobe/ave/UpdateType;

.field public static final enum INITIAL:Lcom/adobe/ave/UpdateType;

.field public static final enum LIVE:Lcom/adobe/ave/UpdateType;

.field public static final enum MASTERMANIFESTUPDATE:Lcom/adobe/ave/UpdateType;


# instance fields
.field private final value:I


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 26
    new-instance v0, Lcom/adobe/ave/UpdateType;

    const-string v1, "INITIAL"

    invoke-direct {v0, v1, v3, v3}, Lcom/adobe/ave/UpdateType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/UpdateType;->INITIAL:Lcom/adobe/ave/UpdateType;

    .line 31
    new-instance v0, Lcom/adobe/ave/UpdateType;

    const-string v1, "LIVE"

    invoke-direct {v0, v1, v4, v4}, Lcom/adobe/ave/UpdateType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/UpdateType;->LIVE:Lcom/adobe/ave/UpdateType;

    .line 36
    new-instance v0, Lcom/adobe/ave/UpdateType;

    const-string v1, "CAPTION_ACTIVITY"

    invoke-direct {v0, v1, v5, v5}, Lcom/adobe/ave/UpdateType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/UpdateType;->CAPTION_ACTIVITY:Lcom/adobe/ave/UpdateType;

    .line 41
    new-instance v0, Lcom/adobe/ave/UpdateType;

    const-string v1, "BACKGROUND"

    invoke-direct {v0, v1, v6, v6}, Lcom/adobe/ave/UpdateType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/UpdateType;->BACKGROUND:Lcom/adobe/ave/UpdateType;

    .line 46
    new-instance v0, Lcom/adobe/ave/UpdateType;

    const-string v1, "MASTERMANIFESTUPDATE"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v7, v2}, Lcom/adobe/ave/UpdateType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/UpdateType;->MASTERMANIFESTUPDATE:Lcom/adobe/ave/UpdateType;

    .line 21
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/adobe/ave/UpdateType;

    sget-object v1, Lcom/adobe/ave/UpdateType;->INITIAL:Lcom/adobe/ave/UpdateType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/adobe/ave/UpdateType;->LIVE:Lcom/adobe/ave/UpdateType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/adobe/ave/UpdateType;->CAPTION_ACTIVITY:Lcom/adobe/ave/UpdateType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/adobe/ave/UpdateType;->BACKGROUND:Lcom/adobe/ave/UpdateType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/adobe/ave/UpdateType;->MASTERMANIFESTUPDATE:Lcom/adobe/ave/UpdateType;

    aput-object v1, v0, v7

    sput-object v0, Lcom/adobe/ave/UpdateType;->$VALUES:[Lcom/adobe/ave/UpdateType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .param p3, "value"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 50
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 51
    iput p3, p0, Lcom/adobe/ave/UpdateType;->value:I

    .line 52
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/ave/UpdateType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 21
    const-class v0, Lcom/adobe/ave/UpdateType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/ave/UpdateType;

    return-object v0
.end method

.method public static values()[Lcom/adobe/ave/UpdateType;
    .locals 1

    .prologue
    .line 21
    sget-object v0, Lcom/adobe/ave/UpdateType;->$VALUES:[Lcom/adobe/ave/UpdateType;

    invoke-virtual {v0}, [Lcom/adobe/ave/UpdateType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/ave/UpdateType;

    return-object v0
.end method


# virtual methods
.method final getValue()I
    .locals 1

    .prologue
    .line 55
    iget v0, p0, Lcom/adobe/ave/UpdateType;->value:I

    return v0
.end method
