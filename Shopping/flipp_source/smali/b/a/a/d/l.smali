.class Lb/a/a/d/l;
.super Lb/a/a/d/k;
.source "SourceFile"


# instance fields
.field protected final d:I


# direct methods
.method protected constructor <init>(Lb/a/a/d;IZI)V
    .locals 0

    .prologue
    .line 1463
    invoke-direct {p0, p1, p2, p3}, Lb/a/a/d/k;-><init>(Lb/a/a/d;IZ)V

    .line 1464
    iput p4, p0, Lb/a/a/d/l;->d:I

    .line 1465
    return-void
.end method


# virtual methods
.method public final a()I
    .locals 1

    .prologue
    .line 1468
    iget v0, p0, Lb/a/a/d/l;->b:I

    return v0
.end method

.method public final a(Ljava/lang/StringBuffer;JLb/a/a/a;ILb/a/a/i;Ljava/util/Locale;)V
    .locals 2

    .prologue
    .line 1475
    :try_start_0
    iget-object v0, p0, Lb/a/a/d/l;->a:Lb/a/a/d;

    invoke-virtual {v0, p4}, Lb/a/a/d;->a(Lb/a/a/a;)Lb/a/a/c;

    move-result-object v0

    .line 1476
    invoke-virtual {v0, p2, p3}, Lb/a/a/c;->a(J)I

    move-result v0

    iget v1, p0, Lb/a/a/d/l;->d:I

    invoke-static {p1, v0, v1}, Lb/a/a/d/y;->a(Ljava/lang/StringBuffer;II)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1480
    :goto_0
    return-void

    .line 1478
    :catch_0
    move-exception v0

    iget v0, p0, Lb/a/a/d/l;->d:I

    invoke-static {p1, v0}, Lb/a/a/d/e;->a(Ljava/lang/StringBuffer;I)V

    goto :goto_0
.end method

.method public final a(Ljava/lang/StringBuffer;Lb/a/a/aa;Ljava/util/Locale;)V
    .locals 2

    .prologue
    .line 1494
    iget-object v0, p0, Lb/a/a/d/l;->a:Lb/a/a/d;

    invoke-interface {p2, v0}, Lb/a/a/aa;->b(Lb/a/a/d;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1496
    :try_start_0
    iget-object v0, p0, Lb/a/a/d/l;->a:Lb/a/a/d;

    invoke-interface {p2, v0}, Lb/a/a/aa;->a(Lb/a/a/d;)I

    move-result v0

    iget v1, p0, Lb/a/a/d/l;->d:I

    invoke-static {p1, v0, v1}, Lb/a/a/d/y;->a(Ljava/lang/StringBuffer;II)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1503
    :goto_0
    return-void

    :catch_0
    move-exception v0

    .line 1498
    :cond_0
    iget v0, p0, Lb/a/a/d/l;->d:I

    invoke-static {p1, v0}, Lb/a/a/d/e;->a(Ljava/lang/StringBuffer;I)V

    goto :goto_0
.end method
