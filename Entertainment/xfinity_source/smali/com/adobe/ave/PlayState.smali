.class public final enum Lcom/adobe/ave/PlayState;
.super Ljava/lang/Enum;
.source "PlayState.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/ave/PlayState;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/ave/PlayState;

.field public static final enum BUFFERFULL:Lcom/adobe/ave/PlayState;

.field public static final enum BUFFERING:Lcom/adobe/ave/PlayState;

.field public static final enum EOF:Lcom/adobe/ave/PlayState;

.field public static final enum PAUSED:Lcom/adobe/ave/PlayState;

.field public static final enum PLAYING:Lcom/adobe/ave/PlayState;

.field public static final enum READY:Lcom/adobe/ave/PlayState;

.field public static final enum SUSPENDED:Lcom/adobe/ave/PlayState;

.field public static final enum TRICK_PLAY:Lcom/adobe/ave/PlayState;

.field public static final enum UNINITIALIZED:Lcom/adobe/ave/PlayState;

.field public static final enum UNRECOVERABLE_ERROR:Lcom/adobe/ave/PlayState;


# instance fields
.field private final value:I


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 26
    new-instance v0, Lcom/adobe/ave/PlayState;

    const-string v1, "UNINITIALIZED"

    invoke-direct {v0, v1, v4, v4}, Lcom/adobe/ave/PlayState;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/PlayState;->UNINITIALIZED:Lcom/adobe/ave/PlayState;

    .line 31
    new-instance v0, Lcom/adobe/ave/PlayState;

    const-string v1, "READY"

    invoke-direct {v0, v1, v5, v5}, Lcom/adobe/ave/PlayState;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/PlayState;->READY:Lcom/adobe/ave/PlayState;

    .line 38
    new-instance v0, Lcom/adobe/ave/PlayState;

    const-string v1, "BUFFERING"

    invoke-direct {v0, v1, v6, v6}, Lcom/adobe/ave/PlayState;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/PlayState;->BUFFERING:Lcom/adobe/ave/PlayState;

    .line 44
    new-instance v0, Lcom/adobe/ave/PlayState;

    const-string v1, "BUFFERFULL"

    invoke-direct {v0, v1, v7, v7}, Lcom/adobe/ave/PlayState;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/PlayState;->BUFFERFULL:Lcom/adobe/ave/PlayState;

    .line 49
    new-instance v0, Lcom/adobe/ave/PlayState;

    const-string v1, "PLAYING"

    invoke-direct {v0, v1, v8, v8}, Lcom/adobe/ave/PlayState;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/PlayState;->PLAYING:Lcom/adobe/ave/PlayState;

    .line 54
    new-instance v0, Lcom/adobe/ave/PlayState;

    const-string v1, "PAUSED"

    const/4 v2, 0x5

    const/4 v3, 0x5

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/PlayState;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/PlayState;->PAUSED:Lcom/adobe/ave/PlayState;

    .line 60
    new-instance v0, Lcom/adobe/ave/PlayState;

    const-string v1, "EOF"

    const/4 v2, 0x6

    const/4 v3, 0x6

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/PlayState;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/PlayState;->EOF:Lcom/adobe/ave/PlayState;

    .line 68
    new-instance v0, Lcom/adobe/ave/PlayState;

    const-string v1, "SUSPENDED"

    const/4 v2, 0x7

    const/4 v3, 0x7

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/PlayState;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/PlayState;->SUSPENDED:Lcom/adobe/ave/PlayState;

    .line 73
    new-instance v0, Lcom/adobe/ave/PlayState;

    const-string v1, "TRICK_PLAY"

    const/16 v2, 0x8

    const/16 v3, 0x8

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/PlayState;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/PlayState;->TRICK_PLAY:Lcom/adobe/ave/PlayState;

    .line 79
    new-instance v0, Lcom/adobe/ave/PlayState;

    const-string v1, "UNRECOVERABLE_ERROR"

    const/16 v2, 0x9

    const/16 v3, 0x9

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/PlayState;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/PlayState;->UNRECOVERABLE_ERROR:Lcom/adobe/ave/PlayState;

    .line 21
    const/16 v0, 0xa

    new-array v0, v0, [Lcom/adobe/ave/PlayState;

    sget-object v1, Lcom/adobe/ave/PlayState;->UNINITIALIZED:Lcom/adobe/ave/PlayState;

    aput-object v1, v0, v4

    sget-object v1, Lcom/adobe/ave/PlayState;->READY:Lcom/adobe/ave/PlayState;

    aput-object v1, v0, v5

    sget-object v1, Lcom/adobe/ave/PlayState;->BUFFERING:Lcom/adobe/ave/PlayState;

    aput-object v1, v0, v6

    sget-object v1, Lcom/adobe/ave/PlayState;->BUFFERFULL:Lcom/adobe/ave/PlayState;

    aput-object v1, v0, v7

    sget-object v1, Lcom/adobe/ave/PlayState;->PLAYING:Lcom/adobe/ave/PlayState;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/adobe/ave/PlayState;->PAUSED:Lcom/adobe/ave/PlayState;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/adobe/ave/PlayState;->EOF:Lcom/adobe/ave/PlayState;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/adobe/ave/PlayState;->SUSPENDED:Lcom/adobe/ave/PlayState;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/adobe/ave/PlayState;->TRICK_PLAY:Lcom/adobe/ave/PlayState;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/adobe/ave/PlayState;->UNRECOVERABLE_ERROR:Lcom/adobe/ave/PlayState;

    aput-object v2, v0, v1

    sput-object v0, Lcom/adobe/ave/PlayState;->$VALUES:[Lcom/adobe/ave/PlayState;

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
    .line 83
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 84
    iput p3, p0, Lcom/adobe/ave/PlayState;->value:I

    .line 85
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/ave/PlayState;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 21
    const-class v0, Lcom/adobe/ave/PlayState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/ave/PlayState;

    return-object v0
.end method

.method public static values()[Lcom/adobe/ave/PlayState;
    .locals 1

    .prologue
    .line 21
    sget-object v0, Lcom/adobe/ave/PlayState;->$VALUES:[Lcom/adobe/ave/PlayState;

    invoke-virtual {v0}, [Lcom/adobe/ave/PlayState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/ave/PlayState;

    return-object v0
.end method


# virtual methods
.method final getValue()I
    .locals 1

    .prologue
    .line 88
    iget v0, p0, Lcom/adobe/ave/PlayState;->value:I

    return v0
.end method
