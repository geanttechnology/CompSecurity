.class public final Lb/a/a/b;
.super Lb/a/a/a/d;
.source "SourceFile"

# interfaces
.implements Lb/a/a/y;
.implements Ljava/io/Serializable;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 155
    invoke-direct {p0}, Lb/a/a/a/d;-><init>()V

    .line 156
    return-void
.end method

.method public constructor <init>(JLb/a/a/a;)V
    .locals 1

    .prologue
    .line 220
    invoke-direct {p0, p1, p2, p3}, Lb/a/a/a/d;-><init>(JLb/a/a/a;)V

    .line 221
    return-void
.end method

.method private constructor <init>(Lb/a/a/i;)V
    .locals 0

    .prologue
    .line 168
    invoke-direct {p0, p1}, Lb/a/a/a/d;-><init>(Lb/a/a/i;)V

    .line 169
    return-void
.end method

.method public static a(Lb/a/a/i;)Lb/a/a/b;
    .locals 2

    .prologue
    .line 101
    if-nez p0, :cond_0

    .line 102
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "Zone must not be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 104
    :cond_0
    new-instance v0, Lb/a/a/b;

    invoke-direct {v0, p0}, Lb/a/a/b;-><init>(Lb/a/a/i;)V

    return-object v0
.end method


# virtual methods
.method public final c_()Lb/a/a/r;
    .locals 4

    .prologue
    .line 1551
    new-instance v0, Lb/a/a/r;

    iget-wide v2, p0, Lb/a/a/a/d;->a:J

    iget-object v1, p0, Lb/a/a/a/d;->b:Lb/a/a/a;

    invoke-direct {v0, v2, v3, v1}, Lb/a/a/r;-><init>(JLb/a/a/a;)V

    return-object v0
.end method
