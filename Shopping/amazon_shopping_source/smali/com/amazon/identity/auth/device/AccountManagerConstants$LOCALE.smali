.class public final enum Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;
.super Ljava/lang/Enum;
.source "AccountManagerConstants.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/AccountManagerConstants;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "LOCALE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

.field public static final enum CA:Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

.field public static final enum CN:Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

.field public static final enum DE:Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

.field public static final enum ES:Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

.field public static final enum FR:Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

.field public static final enum JP:Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

.field public static final enum UK:Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

.field public static final enum US:Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 73
    new-instance v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    const-string/jumbo v1, "US"

    invoke-direct {v0, v1, v3}, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;->US:Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    .line 74
    new-instance v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    const-string/jumbo v1, "DE"

    invoke-direct {v0, v1, v4}, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;->DE:Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    .line 75
    new-instance v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    const-string/jumbo v1, "UK"

    invoke-direct {v0, v1, v5}, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;->UK:Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    .line 76
    new-instance v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    const-string/jumbo v1, "JP"

    invoke-direct {v0, v1, v6}, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;->JP:Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    .line 77
    new-instance v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    const-string/jumbo v1, "FR"

    invoke-direct {v0, v1, v7}, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;->FR:Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    .line 78
    new-instance v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    const-string/jumbo v1, "CA"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;->CA:Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    .line 79
    new-instance v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    const-string/jumbo v1, "ES"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;->ES:Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    .line 80
    new-instance v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    const-string/jumbo v1, "CN"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;->CN:Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    .line 71
    const/16 v0, 0x8

    new-array v0, v0, [Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    sget-object v1, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;->US:Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;->DE:Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;->UK:Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;->JP:Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;->FR:Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;->CA:Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;->ES:Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;->CN:Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;->$VALUES:[Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

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
    .line 71
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 71
    const-class v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;
    .locals 1

    .prologue
    .line 71
    sget-object v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;->$VALUES:[Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    invoke-virtual {v0}, [Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    return-object v0
.end method


# virtual methods
.method public toUrlString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 87
    sget-object v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;->US:Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;

    invoke-virtual {v0, p0}, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 89
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/AccountManagerConstants$LOCALE;->name()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 93
    :goto_0
    return-object v0

    :cond_0
    const-string/jumbo v0, ""

    goto :goto_0
.end method
