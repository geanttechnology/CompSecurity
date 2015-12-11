.class public final enum Lcom/amazon/mobile/mash/event/MASHEventType;
.super Ljava/lang/Enum;
.source "MASHEventType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mobile/mash/event/MASHEventType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mobile/mash/event/MASHEventType;

.field public static final enum appPause:Lcom/amazon/mobile/mash/event/MASHEventType;

.field public static final enum appResume:Lcom/amazon/mobile/mash/event/MASHEventType;

.field public static final enum cartUpdated:Lcom/amazon/mobile/mash/event/MASHEventType;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 11
    new-instance v0, Lcom/amazon/mobile/mash/event/MASHEventType;

    const-string/jumbo v1, "appPause"

    invoke-direct {v0, v1, v2}, Lcom/amazon/mobile/mash/event/MASHEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/event/MASHEventType;->appPause:Lcom/amazon/mobile/mash/event/MASHEventType;

    .line 15
    new-instance v0, Lcom/amazon/mobile/mash/event/MASHEventType;

    const-string/jumbo v1, "appResume"

    invoke-direct {v0, v1, v3}, Lcom/amazon/mobile/mash/event/MASHEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/event/MASHEventType;->appResume:Lcom/amazon/mobile/mash/event/MASHEventType;

    .line 19
    new-instance v0, Lcom/amazon/mobile/mash/event/MASHEventType;

    const-string/jumbo v1, "cartUpdated"

    invoke-direct {v0, v1, v4}, Lcom/amazon/mobile/mash/event/MASHEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mobile/mash/event/MASHEventType;->cartUpdated:Lcom/amazon/mobile/mash/event/MASHEventType;

    .line 7
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/mobile/mash/event/MASHEventType;

    sget-object v1, Lcom/amazon/mobile/mash/event/MASHEventType;->appPause:Lcom/amazon/mobile/mash/event/MASHEventType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/mobile/mash/event/MASHEventType;->appResume:Lcom/amazon/mobile/mash/event/MASHEventType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/mobile/mash/event/MASHEventType;->cartUpdated:Lcom/amazon/mobile/mash/event/MASHEventType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/mobile/mash/event/MASHEventType;->$VALUES:[Lcom/amazon/mobile/mash/event/MASHEventType;

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
    .line 7
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mobile/mash/event/MASHEventType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 7
    const-class v0, Lcom/amazon/mobile/mash/event/MASHEventType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mobile/mash/event/MASHEventType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mobile/mash/event/MASHEventType;
    .locals 1

    .prologue
    .line 7
    sget-object v0, Lcom/amazon/mobile/mash/event/MASHEventType;->$VALUES:[Lcom/amazon/mobile/mash/event/MASHEventType;

    invoke-virtual {v0}, [Lcom/amazon/mobile/mash/event/MASHEventType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mobile/mash/event/MASHEventType;

    return-object v0
.end method
