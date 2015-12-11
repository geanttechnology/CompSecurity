.class final Lb/a/a/e/g;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field final a:Lb/a/a/e/e;

.field final b:Ljava/lang/String;

.field final c:I


# direct methods
.method private constructor <init>(Lb/a/a/e/e;Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 747
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 748
    iput-object p1, p0, Lb/a/a/e/g;->a:Lb/a/a/e/e;

    .line 749
    iput-object p2, p0, Lb/a/a/e/g;->b:Ljava/lang/String;

    .line 750
    iput p3, p0, Lb/a/a/e/g;->c:I

    .line 751
    return-void
.end method

.method static a(Ljava/io/DataInput;)Lb/a/a/e/g;
    .locals 10

    .prologue
    .line 740
    new-instance v7, Lb/a/a/e/g;

    new-instance v0, Lb/a/a/e/e;

    invoke-interface {p0}, Ljava/io/DataInput;->readUnsignedByte()I

    move-result v1

    int-to-char v1, v1

    invoke-interface {p0}, Ljava/io/DataInput;->readUnsignedByte()I

    move-result v2

    invoke-interface {p0}, Ljava/io/DataInput;->readByte()B

    move-result v3

    invoke-interface {p0}, Ljava/io/DataInput;->readUnsignedByte()I

    move-result v4

    invoke-interface {p0}, Ljava/io/DataInput;->readBoolean()Z

    move-result v5

    invoke-static {p0}, Lb/a/a/e/c;->a(Ljava/io/DataInput;)J

    move-result-wide v8

    long-to-int v6, v8

    invoke-direct/range {v0 .. v6}, Lb/a/a/e/e;-><init>(CIIIZI)V

    invoke-interface {p0}, Ljava/io/DataInput;->readUTF()Ljava/lang/String;

    move-result-object v1

    invoke-static {p0}, Lb/a/a/e/c;->a(Ljava/io/DataInput;)J

    move-result-wide v2

    long-to-int v2, v2

    invoke-direct {v7, v0, v1, v2}, Lb/a/a/e/g;-><init>(Lb/a/a/e/e;Ljava/lang/String;I)V

    return-object v7
.end method


# virtual methods
.method public final a(JII)J
    .locals 9

    .prologue
    const/4 v8, 0x1

    const/4 v0, 0x0

    .line 761
    iget-object v2, p0, Lb/a/a/e/g;->a:Lb/a/a/e/e;

    iget-char v1, v2, Lb/a/a/e/e;->a:C

    const/16 v3, 0x77

    if-ne v1, v3, :cond_2

    add-int/2addr p3, p4

    :cond_0
    :goto_0
    int-to-long v4, p3

    add-long/2addr v4, p1

    invoke-static {}, Lb/a/a/b/t;->L()Lb/a/a/b/t;

    move-result-object v3

    invoke-virtual {v3}, Lb/a/a/a;->C()Lb/a/a/c;

    move-result-object v1

    iget v6, v2, Lb/a/a/e/e;->b:I

    invoke-virtual {v1, v4, v5, v6}, Lb/a/a/c;->b(JI)J

    move-result-wide v6

    invoke-virtual {v3}, Lb/a/a/a;->e()Lb/a/a/c;

    move-result-object v1

    invoke-virtual {v1, v6, v7, v0}, Lb/a/a/c;->b(JI)J

    move-result-wide v0

    invoke-virtual {v3}, Lb/a/a/a;->e()Lb/a/a/c;

    move-result-object v6

    iget v7, v2, Lb/a/a/e/e;->f:I

    invoke-virtual {v6, v0, v1, v7}, Lb/a/a/c;->a(JI)J

    move-result-wide v0

    invoke-virtual {v2, v3, v0, v1}, Lb/a/a/e/e;->a(Lb/a/a/a;J)J

    move-result-wide v0

    iget v6, v2, Lb/a/a/e/e;->d:I

    if-nez v6, :cond_3

    cmp-long v4, v0, v4

    if-gtz v4, :cond_1

    invoke-virtual {v3}, Lb/a/a/a;->E()Lb/a/a/c;

    move-result-object v4

    invoke-virtual {v4, v0, v1, v8}, Lb/a/a/c;->a(JI)J

    move-result-wide v0

    invoke-virtual {v2, v3, v0, v1}, Lb/a/a/e/e;->a(Lb/a/a/a;J)J

    move-result-wide v0

    :cond_1
    :goto_1
    int-to-long v2, p3

    sub-long/2addr v0, v2

    return-wide v0

    :cond_2
    iget-char v1, v2, Lb/a/a/e/e;->a:C

    const/16 v3, 0x73

    if-eq v1, v3, :cond_0

    move p3, v0

    goto :goto_0

    :cond_3
    invoke-virtual {v2, v3, v0, v1}, Lb/a/a/e/e;->c(Lb/a/a/a;J)J

    move-result-wide v0

    cmp-long v4, v0, v4

    if-gtz v4, :cond_1

    invoke-virtual {v3}, Lb/a/a/a;->E()Lb/a/a/c;

    move-result-object v4

    invoke-virtual {v4, v0, v1, v8}, Lb/a/a/c;->a(JI)J

    move-result-wide v0

    invoke-virtual {v3}, Lb/a/a/a;->C()Lb/a/a/c;

    move-result-object v4

    iget v5, v2, Lb/a/a/e/e;->b:I

    invoke-virtual {v4, v0, v1, v5}, Lb/a/a/c;->b(JI)J

    move-result-wide v0

    invoke-virtual {v2, v3, v0, v1}, Lb/a/a/e/e;->a(Lb/a/a/a;J)J

    move-result-wide v0

    invoke-virtual {v2, v3, v0, v1}, Lb/a/a/e/e;->c(Lb/a/a/a;J)J

    move-result-wide v0

    goto :goto_1
.end method

.method public final b(JII)J
    .locals 9

    .prologue
    const/4 v0, 0x0

    const/4 v8, -0x1

    .line 768
    iget-object v2, p0, Lb/a/a/e/g;->a:Lb/a/a/e/e;

    iget-char v1, v2, Lb/a/a/e/e;->a:C

    const/16 v3, 0x77

    if-ne v1, v3, :cond_2

    add-int/2addr p3, p4

    :cond_0
    :goto_0
    int-to-long v4, p3

    add-long/2addr v4, p1

    invoke-static {}, Lb/a/a/b/t;->L()Lb/a/a/b/t;

    move-result-object v3

    invoke-virtual {v3}, Lb/a/a/a;->C()Lb/a/a/c;

    move-result-object v1

    iget v6, v2, Lb/a/a/e/e;->b:I

    invoke-virtual {v1, v4, v5, v6}, Lb/a/a/c;->b(JI)J

    move-result-wide v6

    invoke-virtual {v3}, Lb/a/a/a;->e()Lb/a/a/c;

    move-result-object v1

    invoke-virtual {v1, v6, v7, v0}, Lb/a/a/c;->b(JI)J

    move-result-wide v0

    invoke-virtual {v3}, Lb/a/a/a;->e()Lb/a/a/c;

    move-result-object v6

    iget v7, v2, Lb/a/a/e/e;->f:I

    invoke-virtual {v6, v0, v1, v7}, Lb/a/a/c;->a(JI)J

    move-result-wide v0

    invoke-virtual {v2, v3, v0, v1}, Lb/a/a/e/e;->b(Lb/a/a/a;J)J

    move-result-wide v0

    iget v6, v2, Lb/a/a/e/e;->d:I

    if-nez v6, :cond_3

    cmp-long v4, v0, v4

    if-ltz v4, :cond_1

    invoke-virtual {v3}, Lb/a/a/a;->E()Lb/a/a/c;

    move-result-object v4

    invoke-virtual {v4, v0, v1, v8}, Lb/a/a/c;->a(JI)J

    move-result-wide v0

    invoke-virtual {v2, v3, v0, v1}, Lb/a/a/e/e;->b(Lb/a/a/a;J)J

    move-result-wide v0

    :cond_1
    :goto_1
    int-to-long v2, p3

    sub-long/2addr v0, v2

    return-wide v0

    :cond_2
    iget-char v1, v2, Lb/a/a/e/e;->a:C

    const/16 v3, 0x73

    if-eq v1, v3, :cond_0

    move p3, v0

    goto :goto_0

    :cond_3
    invoke-virtual {v2, v3, v0, v1}, Lb/a/a/e/e;->c(Lb/a/a/a;J)J

    move-result-wide v0

    cmp-long v4, v0, v4

    if-ltz v4, :cond_1

    invoke-virtual {v3}, Lb/a/a/a;->E()Lb/a/a/c;

    move-result-object v4

    invoke-virtual {v4, v0, v1, v8}, Lb/a/a/c;->a(JI)J

    move-result-wide v0

    invoke-virtual {v3}, Lb/a/a/a;->C()Lb/a/a/c;

    move-result-object v4

    iget v5, v2, Lb/a/a/e/e;->b:I

    invoke-virtual {v4, v0, v1, v5}, Lb/a/a/c;->b(JI)J

    move-result-wide v0

    invoke-virtual {v2, v3, v0, v1}, Lb/a/a/e/e;->b(Lb/a/a/a;J)J

    move-result-wide v0

    invoke-virtual {v2, v3, v0, v1}, Lb/a/a/e/e;->c(Lb/a/a/a;J)J

    move-result-wide v0

    goto :goto_1
.end method

.method public final equals(Ljava/lang/Object;)Z
    .locals 4

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 780
    if-ne p0, p1, :cond_1

    .line 790
    :cond_0
    :goto_0
    return v0

    .line 783
    :cond_1
    instance-of v2, p1, Lb/a/a/e/g;

    if-eqz v2, :cond_3

    .line 784
    check-cast p1, Lb/a/a/e/g;

    .line 785
    iget v2, p0, Lb/a/a/e/g;->c:I

    iget v3, p1, Lb/a/a/e/g;->c:I

    if-ne v2, v3, :cond_2

    iget-object v2, p0, Lb/a/a/e/g;->b:Ljava/lang/String;

    iget-object v3, p1, Lb/a/a/e/g;->b:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Lb/a/a/e/g;->a:Lb/a/a/e/e;

    iget-object v3, p1, Lb/a/a/e/g;->a:Lb/a/a/e/e;

    invoke-virtual {v2, v3}, Lb/a/a/e/e;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    :cond_2
    move v0, v1

    goto :goto_0

    :cond_3
    move v0, v1

    .line 790
    goto :goto_0
.end method
