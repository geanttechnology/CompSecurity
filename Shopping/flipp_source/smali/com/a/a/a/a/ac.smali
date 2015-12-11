.class public final Lcom/a/a/a/a/ac;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field final a:Ljava/net/URI;

.field final b:Ljava/net/ProxySelector;

.field final c:Lcom/a/a/w;

.field d:Z

.field private final e:Lcom/a/a/a;

.field private final f:Lcom/a/a/c;

.field private final g:Lcom/a/a/a/j;

.field private h:Ljava/net/Proxy;

.field private i:Ljava/net/InetSocketAddress;

.field private j:Ljava/net/Proxy;

.field private k:Ljava/util/Iterator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Iterator",
            "<",
            "Ljava/net/Proxy;",
            ">;"
        }
    .end annotation
.end field

.field private l:[Ljava/net/InetAddress;

.field private m:I

.field private n:I

.field private o:I

.field private final p:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/a/a/v;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/a/a/a;Ljava/net/URI;Ljava/net/ProxySelector;Lcom/a/a/c;Lcom/a/a/a/j;Lcom/a/a/w;)V
    .locals 2

    .prologue
    .line 80
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 74
    const/4 v0, -0x1

    iput v0, p0, Lcom/a/a/a/a/ac;->o:I

    .line 81
    iput-object p1, p0, Lcom/a/a/a/a/ac;->e:Lcom/a/a/a;

    .line 82
    iput-object p2, p0, Lcom/a/a/a/a/ac;->a:Ljava/net/URI;

    .line 83
    iput-object p3, p0, Lcom/a/a/a/a/ac;->b:Ljava/net/ProxySelector;

    .line 84
    iput-object p4, p0, Lcom/a/a/a/a/ac;->f:Lcom/a/a/c;

    .line 85
    iput-object p5, p0, Lcom/a/a/a/a/ac;->g:Lcom/a/a/a/j;

    .line 86
    iput-object p6, p0, Lcom/a/a/a/a/ac;->c:Lcom/a/a/w;

    .line 87
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/a/a/a/a/ac;->p:Ljava/util/List;

    .line 89
    iget-object v0, p1, Lcom/a/a/a;->a:Ljava/net/Proxy;

    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/a/a/a/a/ac;->d:Z

    if-eqz v0, :cond_1

    iput-object v0, p0, Lcom/a/a/a/a/ac;->j:Ljava/net/Proxy;

    .line 90
    :cond_0
    :goto_0
    return-void

    .line 89
    :cond_1
    iget-object v0, p0, Lcom/a/a/a/a/ac;->b:Ljava/net/ProxySelector;

    invoke-virtual {v0, p2}, Ljava/net/ProxySelector;->select(Ljava/net/URI;)Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/a/a/ac;->k:Ljava/util/Iterator;

    goto :goto_0
.end method

.method private d()Ljava/net/Proxy;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 175
    iget-object v0, p0, Lcom/a/a/a/a/ac;->j:Ljava/net/Proxy;

    if-eqz v0, :cond_0

    .line 176
    iput-boolean v3, p0, Lcom/a/a/a/a/ac;->d:Z

    .line 177
    iget-object v0, p0, Lcom/a/a/a/a/ac;->j:Ljava/net/Proxy;

    .line 193
    :goto_0
    return-object v0

    .line 182
    :cond_0
    iget-object v0, p0, Lcom/a/a/a/a/ac;->k:Ljava/util/Iterator;

    if-eqz v0, :cond_2

    .line 183
    :cond_1
    iget-object v0, p0, Lcom/a/a/a/a/ac;->k:Ljava/util/Iterator;

    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 184
    iget-object v0, p0, Lcom/a/a/a/a/ac;->k:Ljava/util/Iterator;

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/net/Proxy;

    .line 185
    invoke-virtual {v0}, Ljava/net/Proxy;->type()Ljava/net/Proxy$Type;

    move-result-object v1

    sget-object v2, Ljava/net/Proxy$Type;->DIRECT:Ljava/net/Proxy$Type;

    if-eq v1, v2, :cond_1

    goto :goto_0

    .line 192
    :cond_2
    iput-boolean v3, p0, Lcom/a/a/a/a/ac;->d:Z

    .line 193
    sget-object v0, Ljava/net/Proxy;->NO_PROXY:Ljava/net/Proxy;

    goto :goto_0
.end method


# virtual methods
.method public final a(Ljava/lang/String;)Lcom/a/a/b;
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 107
    :goto_0
    iget-object v0, p0, Lcom/a/a/a/a/ac;->f:Lcom/a/a/c;

    iget-object v1, p0, Lcom/a/a/a/a/ac;->e:Lcom/a/a/a;

    invoke-virtual {v0, v1}, Lcom/a/a/c;->a(Lcom/a/a/a;)Lcom/a/a/b;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 108
    const-string v1, "GET"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {v0}, Lcom/a/a/b;->b()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 137
    :cond_0
    :goto_1
    return-object v0

    .line 109
    :cond_1
    invoke-virtual {v0}, Lcom/a/a/b;->close()V

    goto :goto_0

    .line 113
    :cond_2
    invoke-virtual {p0}, Lcom/a/a/a/a/ac;->b()Z

    move-result v0

    if-nez v0, :cond_7

    .line 114
    invoke-virtual {p0}, Lcom/a/a/a/a/ac;->a()Z

    move-result v0

    if-nez v0, :cond_5

    .line 115
    iget-boolean v0, p0, Lcom/a/a/a/a/ac;->d:Z

    if-nez v0, :cond_4

    .line 116
    invoke-virtual {p0}, Lcom/a/a/a/a/ac;->c()Z

    move-result v0

    if-nez v0, :cond_3

    .line 117
    new-instance v0, Ljava/util/NoSuchElementException;

    invoke-direct {v0}, Ljava/util/NoSuchElementException;-><init>()V

    throw v0

    .line 119
    :cond_3
    new-instance v1, Lcom/a/a/b;

    iget-object v0, p0, Lcom/a/a/a/a/ac;->p:Ljava/util/List;

    invoke-interface {v0, v3}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/a/a/v;

    invoke-direct {v1, v0}, Lcom/a/a/b;-><init>(Lcom/a/a/v;)V

    move-object v0, v1

    goto :goto_1

    .line 121
    :cond_4
    invoke-direct {p0}, Lcom/a/a/a/a/ac;->d()Ljava/net/Proxy;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/a/a/ac;->h:Ljava/net/Proxy;

    .line 122
    iget-object v0, p0, Lcom/a/a/a/a/ac;->h:Ljava/net/Proxy;

    iput-object v7, p0, Lcom/a/a/a/a/ac;->l:[Ljava/net/InetAddress;

    invoke-virtual {v0}, Ljava/net/Proxy;->type()Ljava/net/Proxy$Type;

    move-result-object v1

    sget-object v4, Ljava/net/Proxy$Type;->DIRECT:Ljava/net/Proxy$Type;

    if-ne v1, v4, :cond_8

    iget-object v0, p0, Lcom/a/a/a/a/ac;->a:Ljava/net/URI;

    invoke-virtual {v0}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/a/a/a/a/ac;->a:Ljava/net/URI;

    invoke-static {v1}, Lcom/a/a/a/u;->a(Ljava/net/URI;)I

    move-result v1

    iput v1, p0, Lcom/a/a/a/a/ac;->n:I

    :goto_2
    iget-object v1, p0, Lcom/a/a/a/a/ac;->g:Lcom/a/a/a/j;

    invoke-interface {v1, v0}, Lcom/a/a/a/j;->a(Ljava/lang/String;)[Ljava/net/InetAddress;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/a/a/ac;->l:[Ljava/net/InetAddress;

    iput v3, p0, Lcom/a/a/a/a/ac;->m:I

    .line 124
    :cond_5
    new-instance v0, Ljava/net/InetSocketAddress;

    iget-object v1, p0, Lcom/a/a/a/a/ac;->l:[Ljava/net/InetAddress;

    iget v4, p0, Lcom/a/a/a/a/ac;->m:I

    add-int/lit8 v5, v4, 0x1

    iput v5, p0, Lcom/a/a/a/a/ac;->m:I

    aget-object v1, v1, v4

    iget v4, p0, Lcom/a/a/a/a/ac;->n:I

    invoke-direct {v0, v1, v4}, Ljava/net/InetSocketAddress;-><init>(Ljava/net/InetAddress;I)V

    iget v1, p0, Lcom/a/a/a/a/ac;->m:I

    iget-object v4, p0, Lcom/a/a/a/a/ac;->l:[Ljava/net/InetAddress;

    array-length v4, v4

    if-ne v1, v4, :cond_6

    iput-object v7, p0, Lcom/a/a/a/a/ac;->l:[Ljava/net/InetAddress;

    iput v3, p0, Lcom/a/a/a/a/ac;->m:I

    :cond_6
    iput-object v0, p0, Lcom/a/a/a/a/ac;->i:Ljava/net/InetSocketAddress;

    .line 125
    iget-object v0, p0, Lcom/a/a/a/a/ac;->e:Lcom/a/a/a;

    iget-object v0, v0, Lcom/a/a/a;->d:Ljavax/net/ssl/SSLSocketFactory;

    if-eqz v0, :cond_a

    move v0, v2

    :goto_3
    iput v0, p0, Lcom/a/a/a/a/ac;->o:I

    .line 128
    :cond_7
    iget v0, p0, Lcom/a/a/a/a/ac;->o:I

    if-ne v0, v2, :cond_b

    iput v3, p0, Lcom/a/a/a/a/ac;->o:I

    move v0, v2

    :goto_4
    if-ne v0, v2, :cond_d

    move v0, v2

    .line 129
    :goto_5
    new-instance v1, Lcom/a/a/v;

    iget-object v4, p0, Lcom/a/a/a/a/ac;->e:Lcom/a/a/a;

    iget-object v5, p0, Lcom/a/a/a/a/ac;->h:Ljava/net/Proxy;

    iget-object v6, p0, Lcom/a/a/a/a/ac;->i:Ljava/net/InetSocketAddress;

    invoke-direct {v1, v4, v5, v6, v0}, Lcom/a/a/v;-><init>(Lcom/a/a/a;Ljava/net/Proxy;Ljava/net/InetSocketAddress;Z)V

    .line 130
    iget-object v0, p0, Lcom/a/a/a/a/ac;->c:Lcom/a/a/w;

    invoke-virtual {v0, v1}, Lcom/a/a/w;->b(Lcom/a/a/v;)Z

    move-result v0

    if-eqz v0, :cond_e

    .line 131
    iget-object v0, p0, Lcom/a/a/a/a/ac;->p:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    .line 122
    :cond_8
    invoke-virtual {v0}, Ljava/net/Proxy;->address()Ljava/net/SocketAddress;

    move-result-object v0

    instance-of v1, v0, Ljava/net/InetSocketAddress;

    if-nez v1, :cond_9

    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Proxy.address() is not an InetSocketAddress: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_9
    check-cast v0, Ljava/net/InetSocketAddress;

    invoke-virtual {v0}, Ljava/net/InetSocketAddress;->getHostName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Ljava/net/InetSocketAddress;->getPort()I

    move-result v0

    iput v0, p0, Lcom/a/a/a/a/ac;->n:I

    move-object v0, v1

    goto/16 :goto_2

    :cond_a
    move v0, v3

    .line 125
    goto :goto_3

    .line 128
    :cond_b
    iget v0, p0, Lcom/a/a/a/a/ac;->o:I

    if-nez v0, :cond_c

    const/4 v0, -0x1

    iput v0, p0, Lcom/a/a/a/a/ac;->o:I

    move v0, v3

    goto :goto_4

    :cond_c
    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    :cond_d
    move v0, v3

    goto :goto_5

    .line 137
    :cond_e
    new-instance v0, Lcom/a/a/b;

    invoke-direct {v0, v1}, Lcom/a/a/b;-><init>(Lcom/a/a/v;)V

    goto/16 :goto_1
.end method

.method final a()Z
    .locals 1

    .prologue
    .line 222
    iget-object v0, p0, Lcom/a/a/a/a/ac;->l:[Ljava/net/InetAddress;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method final b()Z
    .locals 2

    .prologue
    .line 244
    iget v0, p0, Lcom/a/a/a/a/ac;->o:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method final c()Z
    .locals 1

    .prologue
    .line 262
    iget-object v0, p0, Lcom/a/a/a/a/ac;->p:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
