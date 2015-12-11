.class public final Lb/a/a/q;
.super Lb/a/a/a/b;
.source "SourceFile"

# interfaces
.implements Lb/a/a/z;
.implements Ljava/io/Serializable;


# instance fields
.field private final a:J


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 108
    invoke-direct {p0}, Lb/a/a/a/b;-><init>()V

    .line 109
    invoke-static {}, Lb/a/a/f;->a()J

    move-result-wide v0

    iput-wide v0, p0, Lb/a/a/q;->a:J

    .line 110
    return-void
.end method

.method public constructor <init>(J)V
    .locals 1

    .prologue
    .line 118
    invoke-direct {p0}, Lb/a/a/a/b;-><init>()V

    .line 119
    iput-wide p1, p0, Lb/a/a/q;->a:J

    .line 120
    return-void
.end method


# virtual methods
.method public final a()J
    .locals 2

    .prologue
    .line 256
    iget-wide v0, p0, Lb/a/a/q;->a:J

    return-wide v0
.end method

.method public final b()Lb/a/a/a;
    .locals 1

    .prologue
    .line 268
    invoke-static {}, Lb/a/a/b/t;->L()Lb/a/a/b/t;

    move-result-object v0

    return-object v0
.end method
