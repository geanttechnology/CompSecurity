.class public Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;
.super Ljava/lang/Object;
.source "RscResponseHeader.java"


# instance fields
.field private final cookieJar:[B

.field private final exception:Ljava/lang/String;

.field private final secureCookieJar:[B

.field private final status:B


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 2
    .param p1, "exception"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    const/4 v0, 0x1

    iput-byte v0, p0, Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;->status:B

    .line 36
    iput-object p1, p0, Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;->exception:Ljava/lang/String;

    .line 38
    iput-object v1, p0, Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;->cookieJar:[B

    .line 39
    iput-object v1, p0, Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;->secureCookieJar:[B

    .line 40
    return-void
.end method

.method public constructor <init>([B[B)V
    .locals 1
    .param p1, "cookieJar"    # [B
    .param p2, "secureCookieJar"    # [B

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    const/4 v0, 0x0

    iput-byte v0, p0, Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;->status:B

    .line 25
    iput-object p1, p0, Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;->cookieJar:[B

    .line 26
    iput-object p2, p0, Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;->secureCookieJar:[B

    .line 28
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;->exception:Ljava/lang/String;

    .line 29
    return-void
.end method


# virtual methods
.method public getCookieJar()[B
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;->cookieJar:[B

    return-object v0
.end method

.method public getException()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;->exception:Ljava/lang/String;

    return-object v0
.end method

.method public getSecureCookieJar()[B
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;->secureCookieJar:[B

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 49
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 51
    .local v0, "sb":Ljava/lang/StringBuffer;
    const/16 v1, 0x5b

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 52
    const-string/jumbo v1, "rscVersion="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    .line 53
    const-string/jumbo v1, ", status="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-byte v2, p0, Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;->status:B

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    .line 54
    const-string/jumbo v1, ", exception="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;->exception:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 56
    iget-object v1, p0, Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;->cookieJar:[B

    if-nez v1, :cond_0

    .line 57
    const-string/jumbo v1, ", cookieJar=null"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 63
    :goto_0
    iget-object v1, p0, Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;->secureCookieJar:[B

    if-nez v1, :cond_1

    .line 64
    const-string/jumbo v1, ", secureCookieJar=null"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 70
    :goto_1
    const/16 v1, 0x5d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 72
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 60
    :cond_0
    const-string/jumbo v1, ", cookieJar.length="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;->cookieJar:[B

    array-length v2, v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 67
    :cond_1
    const-string/jumbo v1, ", secureCookieJar.length="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/rio/j2me/common/rsc/RscResponseHeader;->secureCookieJar:[B

    array-length v2, v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    goto :goto_1
.end method
