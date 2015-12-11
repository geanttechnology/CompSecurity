.class public final Lcom/a/a/a;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public final a:Ljava/net/Proxy;

.field public final b:Ljava/lang/String;

.field public final c:I

.field public final d:Ljavax/net/ssl/SSLSocketFactory;

.field public final e:Ljavax/net/ssl/HostnameVerifier;

.field final f:Lcom/a/a/o;

.field public final g:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;ILjavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/HostnameVerifier;Lcom/a/a/o;Ljava/net/Proxy;Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I",
            "Ljavax/net/ssl/SSLSocketFactory;",
            "Ljavax/net/ssl/HostnameVerifier;",
            "Lcom/a/a/o;",
            "Ljava/net/Proxy;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "uriHost == null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 50
    :cond_0
    if-gtz p2, :cond_1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "uriPort <= 0: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 51
    :cond_1
    if-nez p5, :cond_2

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "authenticator == null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 52
    :cond_2
    if-nez p7, :cond_3

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "transports == null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 53
    :cond_3
    iput-object p6, p0, Lcom/a/a/a;->a:Ljava/net/Proxy;

    .line 54
    iput-object p1, p0, Lcom/a/a/a;->b:Ljava/lang/String;

    .line 55
    iput p2, p0, Lcom/a/a/a;->c:I

    .line 56
    iput-object p3, p0, Lcom/a/a/a;->d:Ljavax/net/ssl/SSLSocketFactory;

    .line 57
    iput-object p4, p0, Lcom/a/a/a;->e:Ljavax/net/ssl/HostnameVerifier;

    .line 58
    iput-object p5, p0, Lcom/a/a/a;->f:Lcom/a/a/o;

    .line 59
    invoke-static {p7}, Lcom/a/a/a/u;->a(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/a;->g:Ljava/util/List;

    .line 60
    return-void
.end method


# virtual methods
.method public final equals(Ljava/lang/Object;)Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 116
    instance-of v1, p1, Lcom/a/a/a;

    if-eqz v1, :cond_0

    .line 117
    check-cast p1, Lcom/a/a/a;

    .line 118
    iget-object v1, p0, Lcom/a/a/a;->a:Ljava/net/Proxy;

    iget-object v2, p1, Lcom/a/a/a;->a:Ljava/net/Proxy;

    invoke-static {v1, v2}, Lcom/a/a/a/u;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/a/a/a;->b:Ljava/lang/String;

    iget-object v2, p1, Lcom/a/a/a;->b:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget v1, p0, Lcom/a/a/a;->c:I

    iget v2, p1, Lcom/a/a/a;->c:I

    if-ne v1, v2, :cond_0

    iget-object v1, p0, Lcom/a/a/a;->d:Ljavax/net/ssl/SSLSocketFactory;

    iget-object v2, p1, Lcom/a/a/a;->d:Ljavax/net/ssl/SSLSocketFactory;

    invoke-static {v1, v2}, Lcom/a/a/a/u;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/a/a/a;->e:Ljavax/net/ssl/HostnameVerifier;

    iget-object v2, p1, Lcom/a/a/a;->e:Ljavax/net/ssl/HostnameVerifier;

    invoke-static {v1, v2}, Lcom/a/a/a/u;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/a/a/a;->f:Lcom/a/a/o;

    iget-object v2, p1, Lcom/a/a/a;->f:Lcom/a/a/o;

    invoke-static {v1, v2}, Lcom/a/a/a/u;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/a/a/a;->g:Ljava/util/List;

    iget-object v2, p1, Lcom/a/a/a;->g:Ljava/util/List;

    invoke-static {v1, v2}, Lcom/a/a/a/u;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    .line 126
    :cond_0
    return v0
.end method

.method public final hashCode()I
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 130
    iget-object v0, p0, Lcom/a/a/a;->b:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    add-int/lit16 v0, v0, 0x20f

    .line 132
    mul-int/lit8 v0, v0, 0x1f

    iget v2, p0, Lcom/a/a/a;->c:I

    add-int/2addr v0, v2

    .line 133
    mul-int/lit8 v2, v0, 0x1f

    iget-object v0, p0, Lcom/a/a/a;->d:Ljavax/net/ssl/SSLSocketFactory;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/a/a/a;->d:Ljavax/net/ssl/SSLSocketFactory;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    :goto_0
    add-int/2addr v0, v2

    .line 134
    mul-int/lit8 v2, v0, 0x1f

    iget-object v0, p0, Lcom/a/a/a;->e:Ljavax/net/ssl/HostnameVerifier;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/a/a/a;->e:Ljavax/net/ssl/HostnameVerifier;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    :goto_1
    add-int/2addr v0, v2

    .line 135
    mul-int/lit8 v2, v0, 0x1f

    iget-object v0, p0, Lcom/a/a/a;->f:Lcom/a/a/o;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/a/a/a;->f:Lcom/a/a/o;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    :goto_2
    add-int/2addr v0, v2

    .line 136
    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lcom/a/a/a;->a:Ljava/net/Proxy;

    if-eqz v2, :cond_0

    iget-object v1, p0, Lcom/a/a/a;->a:Ljava/net/Proxy;

    invoke-virtual {v1}, Ljava/net/Proxy;->hashCode()I

    move-result v1

    :cond_0
    add-int/2addr v0, v1

    .line 137
    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lcom/a/a/a;->g:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    .line 138
    return v0

    :cond_1
    move v0, v1

    .line 133
    goto :goto_0

    :cond_2
    move v0, v1

    .line 134
    goto :goto_1

    :cond_3
    move v0, v1

    .line 135
    goto :goto_2
.end method
