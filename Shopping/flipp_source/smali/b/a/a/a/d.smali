.class public abstract Lb/a/a/a/d;
.super Lb/a/a/a/a;
.source "SourceFile"

# interfaces
.implements Lb/a/a/y;
.implements Ljava/io/Serializable;


# instance fields
.field public volatile a:J

.field public volatile b:Lb/a/a/a;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 61
    invoke-static {}, Lb/a/a/f;->a()J

    move-result-wide v0

    invoke-static {}, Lb/a/a/b/t;->M()Lb/a/a/b/t;

    move-result-object v2

    invoke-direct {p0, v0, v1, v2}, Lb/a/a/a/d;-><init>(JLb/a/a/a;)V

    .line 62
    return-void
.end method

.method public constructor <init>(JLb/a/a/a;)V
    .locals 1

    .prologue
    .line 124
    invoke-direct {p0}, Lb/a/a/a/a;-><init>()V

    .line 125
    invoke-static {p3}, Lb/a/a/f;->a(Lb/a/a/a;)Lb/a/a/a;

    move-result-object v0

    iput-object v0, p0, Lb/a/a/a/d;->b:Lb/a/a/a;

    .line 126
    iget-object v0, p0, Lb/a/a/a/d;->b:Lb/a/a/a;

    iput-wide p1, p0, Lb/a/a/a/d;->a:J

    .line 127
    return-void
.end method

.method public constructor <init>(Lb/a/a/i;)V
    .locals 3

    .prologue
    .line 73
    invoke-static {}, Lb/a/a/f;->a()J

    move-result-wide v0

    invoke-static {p1}, Lb/a/a/b/t;->b(Lb/a/a/i;)Lb/a/a/b/t;

    move-result-object v2

    invoke-direct {p0, v0, v1, v2}, Lb/a/a/a/d;-><init>(JLb/a/a/a;)V

    .line 74
    return-void
.end method

.method public constructor <init>(Lb/a/a/i;B)V
    .locals 3

    .prologue
    .line 110
    const-wide/16 v0, 0x0

    invoke-static {p1}, Lb/a/a/b/t;->b(Lb/a/a/i;)Lb/a/a/b/t;

    move-result-object v2

    invoke-direct {p0, v0, v1, v2}, Lb/a/a/a/d;-><init>(JLb/a/a/a;)V

    .line 111
    return-void
.end method


# virtual methods
.method public final a()J
    .locals 2

    .prologue
    .line 295
    iget-wide v0, p0, Lb/a/a/a/d;->a:J

    return-wide v0
.end method

.method public a(J)V
    .locals 1

    .prologue
    .line 317
    iget-object v0, p0, Lb/a/a/a/d;->b:Lb/a/a/a;

    iput-wide p1, p0, Lb/a/a/a/d;->a:J

    .line 318
    return-void
.end method

.method public final b()Lb/a/a/a;
    .locals 1

    .prologue
    .line 304
    iget-object v0, p0, Lb/a/a/a/d;->b:Lb/a/a/a;

    return-object v0
.end method
