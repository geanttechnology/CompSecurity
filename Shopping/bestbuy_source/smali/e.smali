.class public abstract Le;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private a:Ljava/net/URL;

.field private b:I

.field private c:I

.field private d:Ljava/util/Map;

.field private e:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Le;->d:Ljava/util/Map;

    return-void
.end method


# virtual methods
.method public a()Ljava/net/URL;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Le;->a:Ljava/net/URL;

    return-object v0
.end method

.method public a(I)V
    .locals 0

    .prologue
    .line 45
    iput p1, p0, Le;->b:I

    .line 46
    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 86
    iput-object p1, p0, Le;->e:Ljava/lang/String;

    .line 87
    return-void
.end method

.method public a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 70
    iget-object v0, p0, Le;->d:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 71
    iget-object v0, p0, Le;->d:Ljava/util/Map;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 73
    :cond_0
    iget-object v0, p0, Le;->d:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 74
    return-void
.end method

.method public a(Ljava/net/URL;)V
    .locals 0

    .prologue
    .line 34
    iput-object p1, p0, Le;->a:Ljava/net/URL;

    .line 35
    return-void
.end method

.method public b()I
    .locals 1

    .prologue
    .line 49
    iget v0, p0, Le;->b:I

    return v0
.end method

.method public b(I)V
    .locals 0

    .prologue
    .line 56
    iput p1, p0, Le;->c:I

    .line 57
    return-void
.end method

.method public c()I
    .locals 1

    .prologue
    .line 60
    iget v0, p0, Le;->c:I

    return v0
.end method

.method public d()Ljava/util/Map;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Le;->d:Ljava/util/Map;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public e()Ljava/lang/String;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Le;->e:Ljava/lang/String;

    return-object v0
.end method

.method public abstract f()Ljava/io/OutputStream;
.end method

.method public abstract g()Ljava/io/InputStream;
.end method

.method public abstract h()I
.end method
