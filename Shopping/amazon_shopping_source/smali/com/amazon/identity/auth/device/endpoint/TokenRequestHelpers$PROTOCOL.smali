.class public final enum Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;
.super Ljava/lang/Enum;
.source "TokenRequestHelpers.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "PROTOCOL"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;

.field public static final enum HTTPS:Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 18
    new-instance v0, Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;

    const-string/jumbo v1, "HTTPS"

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;->HTTPS:Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;

    .line 16
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;

    const/4 v1, 0x0

    sget-object v2, Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;->HTTPS:Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;->$VALUES:[Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 16
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 16
    const-class v0, Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;
    .locals 1

    .prologue
    .line 16
    sget-object v0, Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;->$VALUES:[Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;

    invoke-virtual {v0}, [Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 23
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-super {p0}, Ljava/lang/Enum;->toString()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "://"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
