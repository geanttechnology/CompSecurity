.class public abstract Lb/a/a/c/c;
.super Lb/a/a/l;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# instance fields
.field final d:Lb/a/a/m;


# direct methods
.method public constructor <init>(Lb/a/a/m;)V
    .locals 2

    .prologue
    .line 47
    invoke-direct {p0}, Lb/a/a/l;-><init>()V

    .line 48
    if-nez p1, :cond_0

    .line 49
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "The type must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 51
    :cond_0
    iput-object p1, p0, Lb/a/a/c/c;->d:Lb/a/a/m;

    .line 52
    return-void
.end method


# virtual methods
.method public final a()Lb/a/a/m;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lb/a/a/c/c;->d:Lb/a/a/m;

    return-object v0
.end method

.method public b(JJ)I
    .locals 3

    .prologue
    .line 141
    invoke-virtual {p0, p1, p2, p3, p4}, Lb/a/a/c/c;->c(JJ)J

    move-result-wide v0

    invoke-static {v0, v1}, Lb/a/a/c/g;->a(J)I

    move-result v0

    return v0
.end method

.method public final b()Z
    .locals 1

    .prologue
    .line 66
    const/4 v0, 0x1

    return v0
.end method

.method public synthetic compareTo(Ljava/lang/Object;)I
    .locals 5

    .prologue
    .line 38
    check-cast p1, Lb/a/a/l;

    invoke-virtual {p1}, Lb/a/a/l;->d()J

    move-result-wide v0

    invoke-virtual {p0}, Lb/a/a/c/c;->d()J

    move-result-wide v2

    cmp-long v4, v2, v0

    if-nez v4, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    cmp-long v0, v2, v0

    if-gez v0, :cond_1

    const/4 v0, -0x1

    goto :goto_0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 165
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "DurationField["

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lb/a/a/c/c;->d:Lb/a/a/m;

    iget-object v1, v1, Lb/a/a/m;->m:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x5d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
