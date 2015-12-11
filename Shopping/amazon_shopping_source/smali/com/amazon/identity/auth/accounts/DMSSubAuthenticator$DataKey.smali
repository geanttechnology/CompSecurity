.class Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;
.super Ljava/lang/Object;
.source "DMSSubAuthenticator.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "DataKey"
.end annotation


# instance fields
.field public final deviceTypeInvariantForm:Ljava/lang/String;

.field public final legacyToken:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "givenLegacyToken"    # Ljava/lang/String;
    .param p2, "givenDeviceTypeInvariantForm"    # Ljava/lang/String;

    .prologue
    .line 69
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 70
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;->legacyToken:Ljava/lang/String;

    .line 71
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;->deviceTypeInvariantForm:Ljava/lang/String;

    .line 72
    return-void
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 77
    const-string/jumbo v1, "[%s,%s]"

    const/4 v0, 0x2

    new-array v2, v0, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;->legacyToken:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;->legacyToken:Ljava/lang/String;

    :goto_0
    aput-object v0, v2, v3

    const/4 v3, 0x1

    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;->deviceTypeInvariantForm:Ljava/lang/String;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;->deviceTypeInvariantForm:Ljava/lang/String;

    :goto_1
    aput-object v0, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_0
    const-string/jumbo v0, "none"

    goto :goto_0

    :cond_1
    const-string/jumbo v0, "none"

    goto :goto_1
.end method
