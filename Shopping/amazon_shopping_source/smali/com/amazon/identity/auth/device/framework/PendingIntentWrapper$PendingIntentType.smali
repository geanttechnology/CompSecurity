.class public final enum Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;
.super Ljava/lang/Enum;
.source "PendingIntentWrapper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "PendingIntentType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;

.field public static final enum Activity:Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;

.field public static final enum Broadcast:Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;

.field public static final enum Service:Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 12
    new-instance v0, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;

    const-string/jumbo v1, "Broadcast"

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;->Broadcast:Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;

    .line 13
    new-instance v0, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;

    const-string/jumbo v1, "Service"

    invoke-direct {v0, v1, v3}, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;->Service:Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;

    .line 14
    new-instance v0, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;

    const-string/jumbo v1, "Activity"

    invoke-direct {v0, v1, v4}, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;->Activity:Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;

    .line 10
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;

    sget-object v1, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;->Broadcast:Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;->Service:Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;->Activity:Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;->$VALUES:[Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;

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
    .line 10
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 10
    const-class v0, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;
    .locals 1

    .prologue
    .line 10
    sget-object v0, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;->$VALUES:[Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;

    invoke-virtual {v0}, [Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType;

    return-object v0
.end method
