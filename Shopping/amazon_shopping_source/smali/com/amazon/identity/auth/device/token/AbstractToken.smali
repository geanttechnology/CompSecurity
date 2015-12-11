.class public abstract Lcom/amazon/identity/auth/device/token/AbstractToken;
.super Ljava/lang/Object;
.source "AbstractToken.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/token/Token;


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field protected final mLocalCreationTimestamp:Landroid/text/format/Time;

.field private final mToken:Ljava/lang/String;

.field protected mTokenData:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/amazon/identity/auth/device/token/AbstractToken;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/token/AbstractToken;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    new-instance v0, Landroid/text/format/Time;

    invoke-direct {v0}, Landroid/text/format/Time;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mLocalCreationTimestamp:Landroid/text/format/Time;

    .line 34
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mToken:Ljava/lang/String;

    .line 35
    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/device/token/AbstractToken;)V
    .locals 2
    .param p1, "token"    # Lcom/amazon/identity/auth/device/token/AbstractToken;

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    new-instance v0, Landroid/text/format/Time;

    invoke-direct {v0}, Landroid/text/format/Time;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mLocalCreationTimestamp:Landroid/text/format/Time;

    .line 43
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/token/AbstractToken;->getToken()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 45
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Token string may not be null for an AbstractToken"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 47
    :cond_1
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/token/AbstractToken;->getToken()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mToken:Ljava/lang/String;

    .line 48
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mLocalCreationTimestamp:Landroid/text/format/Time;

    iget-object v1, p1, Lcom/amazon/identity/auth/device/token/AbstractToken;->mLocalCreationTimestamp:Landroid/text/format/Time;

    invoke-virtual {v0, v1}, Landroid/text/format/Time;->set(Landroid/text/format/Time;)V

    .line 49
    new-instance v0, Ljava/util/HashMap;

    iget-object v1, p1, Lcom/amazon/identity/auth/device/token/AbstractToken;->mTokenData:Ljava/util/Map;

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mTokenData:Ljava/util/Map;

    .line 50
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 4
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    new-instance v0, Landroid/text/format/Time;

    invoke-direct {v0}, Landroid/text/format/Time;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mLocalCreationTimestamp:Landroid/text/format/Time;

    .line 58
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 60
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Token string may not be null for an AbstractToken"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 62
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mToken:Ljava/lang/String;

    .line 63
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mLocalCreationTimestamp:Landroid/text/format/Time;

    invoke-virtual {v0}, Landroid/text/format/Time;->setToNow()V

    .line 64
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mTokenData:Ljava/util/Map;

    .line 65
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mTokenData:Ljava/util/Map;

    const-string/jumbo v1, "token"

    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mToken:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mTokenData:Ljava/util/Map;

    const-string/jumbo v1, "creation_time"

    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mLocalCreationTimestamp:Landroid/text/format/Time;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/text/format/Time;->toMillis(Z)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 66
    return-void
.end method

.method public constructor <init>(Ljava/util/Map;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "tokenData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v4, 0x0

    .line 76
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    new-instance v1, Landroid/text/format/Time;

    invoke-direct {v1}, Landroid/text/format/Time;-><init>()V

    iput-object v1, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mLocalCreationTimestamp:Landroid/text/format/Time;

    .line 77
    const-string/jumbo v1, "token"

    invoke-interface {p1, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    iput-object v1, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mToken:Ljava/lang/String;

    .line 78
    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mToken:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 80
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "Token string may not be null for an AbstractToken"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 83
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mTokenData:Ljava/util/Map;

    .line 86
    const-string/jumbo v1, "creation_time"

    invoke-interface {p1, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 87
    .local v0, "creationTimeMillis":Ljava/lang/String;
    if-nez v0, :cond_1

    .line 89
    sget-object v1, Lcom/amazon/identity/auth/device/token/AbstractToken;->LOG_TAG:Ljava/lang/String;

    .line 91
    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mLocalCreationTimestamp:Landroid/text/format/Time;

    invoke-virtual {v1}, Landroid/text/format/Time;->setToNow()V

    .line 92
    const-string/jumbo v1, "creation_time"

    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mLocalCreationTimestamp:Landroid/text/format/Time;

    invoke-virtual {v2, v4}, Landroid/text/format/Time;->toMillis(Z)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 109
    :goto_0
    return-void

    .line 99
    :cond_1
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mLocalCreationTimestamp:Landroid/text/format/Time;

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Landroid/text/format/Time;->set(J)V
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 103
    :catch_0
    move-exception v1

    sget-object v1, Lcom/amazon/identity/auth/device/token/AbstractToken;->LOG_TAG:Ljava/lang/String;

    .line 105
    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mLocalCreationTimestamp:Landroid/text/format/Time;

    invoke-virtual {v1}, Landroid/text/format/Time;->setToNow()V

    .line 106
    const-string/jumbo v1, "creation_time"

    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mLocalCreationTimestamp:Landroid/text/format/Time;

    invoke-virtual {v2, v4}, Landroid/text/format/Time;->toMillis(Z)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public static convertStringToRegionHint(Ljava/lang/String;)Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;
    .locals 1
    .param p0, "sRegionHint"    # Ljava/lang/String;

    .prologue
    .line 144
    sget-object v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;->EU:Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 146
    sget-object v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;->EU:Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;

    .line 158
    :goto_0
    return-object v0

    .line 148
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;->FE:Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 150
    sget-object v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;->FE:Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;

    goto :goto_0

    .line 152
    :cond_1
    sget-object v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;->CN:Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 154
    sget-object v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;->CN:Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;

    goto :goto_0

    .line 158
    :cond_2
    sget-object v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;->NA:Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;

    goto :goto_0
.end method

.method protected static millisToSecs(J)J
    .locals 2
    .param p0, "milliSeconds"    # J

    .prologue
    .line 178
    const-wide/16 v0, 0x3e8

    div-long v0, p0, v0

    return-wide v0
.end method

.method protected static secsToMillis(J)J
    .locals 2
    .param p0, "seconds"    # J

    .prologue
    .line 172
    const-wide/16 v0, 0x3e8

    mul-long/2addr v0, p0

    return-wide v0
.end method


# virtual methods
.method public final getData()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 134
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mTokenData:Ljava/util/Map;

    return-object v0
.end method

.method public getDirectedId()Ljava/lang/String;
    .locals 2

    .prologue
    .line 186
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mTokenData:Ljava/util/Map;

    const-string/jumbo v1, "directedid"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public getLocalTimestamp()Landroid/text/format/Time;
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mLocalCreationTimestamp:Landroid/text/format/Time;

    return-object v0
.end method

.method protected final getToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 124
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/AbstractToken;->mToken:Ljava/lang/String;

    return-object v0
.end method
