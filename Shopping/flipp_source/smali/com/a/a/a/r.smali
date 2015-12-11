.class final Lcom/a/a/a/r;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/reflect/InvocationHandler;


# instance fields
.field private final a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private b:Z

.field private c:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 389
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 390
    iput-object p1, p0, Lcom/a/a/a/r;->a:Ljava/util/List;

    .line 391
    return-void
.end method

.method static synthetic a(Lcom/a/a/a/r;)Z
    .locals 1

    .prologue
    .line 384
    iget-boolean v0, p0, Lcom/a/a/a/r;->b:Z

    return v0
.end method

.method static synthetic b(Lcom/a/a/a/r;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 384
    iget-object v0, p0, Lcom/a/a/a/r;->c:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public final invoke(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;
    .locals 6

    .prologue
    const/4 v1, 0x0

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 394
    invoke-virtual {p2}, Ljava/lang/reflect/Method;->getName()Ljava/lang/String;

    move-result-object v0

    .line 395
    invoke-virtual {p2}, Ljava/lang/reflect/Method;->getReturnType()Ljava/lang/Class;

    move-result-object v2

    .line 396
    if-nez p3, :cond_0

    .line 397
    sget-object p3, Lcom/a/a/a/u;->b:[Ljava/lang/String;

    .line 399
    :cond_0
    const-string v3, "supports"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    sget-object v3, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    if-ne v3, v2, :cond_1

    .line 400
    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 418
    :goto_0
    return-object v0

    .line 401
    :cond_1
    const-string v3, "unsupported"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    sget-object v3, Ljava/lang/Void;->TYPE:Ljava/lang/Class;

    if-ne v3, v2, :cond_2

    .line 402
    iput-boolean v5, p0, Lcom/a/a/a/r;->b:Z

    move-object v0, v1

    .line 403
    goto :goto_0

    .line 404
    :cond_2
    const-string v3, "protocols"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    array-length v3, p3

    if-nez v3, :cond_3

    .line 405
    iget-object v0, p0, Lcom/a/a/a/r;->a:Ljava/util/List;

    goto :goto_0

    .line 406
    :cond_3
    const-string v3, "selectProtocol"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    const-class v3, Ljava/lang/String;

    if-ne v3, v2, :cond_5

    array-length v2, p3

    if-ne v2, v5, :cond_5

    aget-object v2, p3, v4

    if-eqz v2, :cond_4

    aget-object v2, p3, v4

    instance-of v2, v2, Ljava/util/List;

    if-eqz v2, :cond_5

    .line 411
    :cond_4
    iget-object v0, p0, Lcom/a/a/a/r;->a:Ljava/util/List;

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/a/a/a/r;->c:Ljava/lang/String;

    .line 413
    iget-object v0, p0, Lcom/a/a/a/r;->c:Ljava/lang/String;

    goto :goto_0

    .line 414
    :cond_5
    const-string v2, "protocolSelected"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    array-length v0, p3

    if-ne v0, v5, :cond_6

    .line 415
    aget-object v0, p3, v4

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/a/a/a/r;->c:Ljava/lang/String;

    move-object v0, v1

    .line 416
    goto :goto_0

    .line 418
    :cond_6
    invoke-virtual {p2, p0, p3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method
