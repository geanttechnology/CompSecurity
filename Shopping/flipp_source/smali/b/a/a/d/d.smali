.class public final Lb/a/a/d/d;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public final a:Lb/a/a/d/x;

.field public final b:Lb/a/a/d/t;

.field public final c:Ljava/util/Locale;

.field public final d:Z

.field public final e:Lb/a/a/a;

.field public final f:Lb/a/a/i;

.field public final g:Ljava/lang/Integer;

.field public final h:I


# direct methods
.method public constructor <init>(Lb/a/a/d/x;Lb/a/a/d/t;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 109
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 110
    iput-object p1, p0, Lb/a/a/d/d;->a:Lb/a/a/d/x;

    .line 111
    iput-object p2, p0, Lb/a/a/d/d;->b:Lb/a/a/d/t;

    .line 112
    iput-object v1, p0, Lb/a/a/d/d;->c:Ljava/util/Locale;

    .line 113
    const/4 v0, 0x0

    iput-boolean v0, p0, Lb/a/a/d/d;->d:Z

    .line 114
    iput-object v1, p0, Lb/a/a/d/d;->e:Lb/a/a/a;

    .line 115
    iput-object v1, p0, Lb/a/a/d/d;->f:Lb/a/a/i;

    .line 116
    iput-object v1, p0, Lb/a/a/d/d;->g:Ljava/lang/Integer;

    .line 117
    const/16 v0, 0x7d0

    iput v0, p0, Lb/a/a/d/d;->h:I

    .line 118
    return-void
.end method

.method public constructor <init>(Lb/a/a/d/x;Lb/a/a/d/t;Ljava/util/Locale;ZLb/a/a/a;Lb/a/a/i;Ljava/lang/Integer;I)V
    .locals 0

    .prologue
    .line 128
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 129
    iput-object p1, p0, Lb/a/a/d/d;->a:Lb/a/a/d/x;

    .line 130
    iput-object p2, p0, Lb/a/a/d/d;->b:Lb/a/a/d/t;

    .line 131
    iput-object p3, p0, Lb/a/a/d/d;->c:Ljava/util/Locale;

    .line 132
    iput-boolean p4, p0, Lb/a/a/d/d;->d:Z

    .line 133
    iput-object p5, p0, Lb/a/a/d/d;->e:Lb/a/a/a;

    .line 134
    iput-object p6, p0, Lb/a/a/d/d;->f:Lb/a/a/i;

    .line 135
    iput-object p7, p0, Lb/a/a/d/d;->g:Ljava/lang/Integer;

    .line 136
    iput p8, p0, Lb/a/a/d/d;->h:I

    .line 137
    return-void
.end method


# virtual methods
.method public final a(Lb/a/a/a;)Lb/a/a/a;
    .locals 2

    .prologue
    .line 942
    invoke-static {p1}, Lb/a/a/f;->a(Lb/a/a/a;)Lb/a/a/a;

    move-result-object v0

    .line 943
    iget-object v1, p0, Lb/a/a/d/d;->e:Lb/a/a/a;

    if-eqz v1, :cond_0

    .line 944
    iget-object v0, p0, Lb/a/a/d/d;->e:Lb/a/a/a;

    .line 946
    :cond_0
    iget-object v1, p0, Lb/a/a/d/d;->f:Lb/a/a/i;

    if-eqz v1, :cond_1

    .line 947
    iget-object v1, p0, Lb/a/a/d/d;->f:Lb/a/a/i;

    invoke-virtual {v0, v1}, Lb/a/a/a;->a(Lb/a/a/i;)Lb/a/a/a;

    move-result-object v0

    .line 949
    :cond_1
    return-object v0
.end method

.method public final a(Ljava/lang/String;)Lb/a/a/b;
    .locals 6

    .prologue
    .line 849
    invoke-virtual {p0}, Lb/a/a/d/d;->b()Lb/a/a/d/t;

    move-result-object v1

    .line 851
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lb/a/a/d/d;->a(Lb/a/a/a;)Lb/a/a/a;

    move-result-object v0

    .line 852
    new-instance v2, Lb/a/a/d/u;

    iget-object v3, p0, Lb/a/a/d/d;->c:Ljava/util/Locale;

    iget-object v4, p0, Lb/a/a/d/d;->g:Ljava/lang/Integer;

    iget v5, p0, Lb/a/a/d/d;->h:I

    invoke-direct {v2, v0, v3, v4, v5}, Lb/a/a/d/u;-><init>(Lb/a/a/a;Ljava/util/Locale;Ljava/lang/Integer;I)V

    .line 853
    const/4 v3, 0x0

    invoke-interface {v1, v2, p1, v3}, Lb/a/a/d/t;->a(Lb/a/a/d/u;Ljava/lang/String;I)I

    move-result v1

    .line 854
    if-ltz v1, :cond_3

    .line 855
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v3

    if-lt v1, v3, :cond_5

    .line 856
    invoke-virtual {v2, p1}, Lb/a/a/d/u;->a(Ljava/lang/String;)J

    move-result-wide v4

    .line 857
    iget-boolean v1, p0, Lb/a/a/d/d;->d:Z

    if-eqz v1, :cond_1

    iget-object v1, v2, Lb/a/a/d/u;->c:Ljava/lang/Integer;

    if-eqz v1, :cond_1

    .line 858
    iget-object v1, v2, Lb/a/a/d/u;->c:Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    .line 859
    invoke-static {v1}, Lb/a/a/i;->a(I)Lb/a/a/i;

    move-result-object v1

    .line 860
    invoke-virtual {v0, v1}, Lb/a/a/a;->a(Lb/a/a/i;)Lb/a/a/a;

    move-result-object v0

    .line 864
    :cond_0
    :goto_0
    new-instance v1, Lb/a/a/b;

    invoke-direct {v1, v4, v5, v0}, Lb/a/a/b;-><init>(JLb/a/a/a;)V

    .line 865
    iget-object v0, p0, Lb/a/a/d/d;->f:Lb/a/a/i;

    if-eqz v0, :cond_4

    .line 866
    iget-object v0, p0, Lb/a/a/d/d;->f:Lb/a/a/i;

    iget-object v2, v1, Lb/a/a/a/d;->b:Lb/a/a/a;

    invoke-virtual {v2, v0}, Lb/a/a/a;->a(Lb/a/a/i;)Lb/a/a/a;

    move-result-object v0

    invoke-static {v0}, Lb/a/a/f;->a(Lb/a/a/a;)Lb/a/a/a;

    move-result-object v2

    iget-object v0, v1, Lb/a/a/a/d;->b:Lb/a/a/a;

    if-ne v2, v0, :cond_2

    move-object v0, v1

    .line 868
    :goto_1
    return-object v0

    .line 861
    :cond_1
    iget-object v1, v2, Lb/a/a/d/u;->b:Lb/a/a/i;

    if-eqz v1, :cond_0

    .line 862
    iget-object v1, v2, Lb/a/a/d/u;->b:Lb/a/a/i;

    invoke-virtual {v0, v1}, Lb/a/a/a;->a(Lb/a/a/i;)Lb/a/a/a;

    move-result-object v0

    goto :goto_0

    .line 866
    :cond_2
    new-instance v0, Lb/a/a/b;

    iget-wide v4, v1, Lb/a/a/a/d;->a:J

    invoke-direct {v0, v4, v5, v2}, Lb/a/a/b;-><init>(JLb/a/a/a;)V

    goto :goto_1

    .line 871
    :cond_3
    xor-int/lit8 v0, v1, -0x1

    .line 873
    :goto_2
    new-instance v1, Ljava/lang/IllegalArgumentException;

    invoke-static {p1, v0}, Lb/a/a/d/y;->b(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_4
    move-object v0, v1

    goto :goto_1

    :cond_5
    move v0, v1

    goto :goto_2
.end method

.method public final a(Lb/a/a/i;)Lb/a/a/d/d;
    .locals 9

    .prologue
    .line 321
    iget-object v0, p0, Lb/a/a/d/d;->f:Lb/a/a/i;

    if-ne v0, p1, :cond_0

    .line 324
    :goto_0
    return-object p0

    :cond_0
    new-instance v0, Lb/a/a/d/d;

    iget-object v1, p0, Lb/a/a/d/d;->a:Lb/a/a/d/x;

    iget-object v2, p0, Lb/a/a/d/d;->b:Lb/a/a/d/t;

    iget-object v3, p0, Lb/a/a/d/d;->c:Ljava/util/Locale;

    const/4 v4, 0x0

    iget-object v5, p0, Lb/a/a/d/d;->e:Lb/a/a/a;

    iget-object v7, p0, Lb/a/a/d/d;->g:Ljava/lang/Integer;

    iget v8, p0, Lb/a/a/d/d;->h:I

    move-object v6, p1

    invoke-direct/range {v0 .. v8}, Lb/a/a/d/d;-><init>(Lb/a/a/d/x;Lb/a/a/d/t;Ljava/util/Locale;ZLb/a/a/a;Lb/a/a/i;Ljava/lang/Integer;I)V

    move-object p0, v0

    goto :goto_0
.end method

.method public final a()Lb/a/a/d/x;
    .locals 2

    .prologue
    .line 658
    iget-object v0, p0, Lb/a/a/d/d;->a:Lb/a/a/d/x;

    .line 659
    if-nez v0, :cond_0

    .line 660
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "Printing not supported"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 662
    :cond_0
    return-object v0
.end method

.method public final a(Lb/a/a/z;)Ljava/lang/String;
    .locals 14

    .prologue
    const-wide/16 v12, 0x0

    .line 583
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-virtual {p0}, Lb/a/a/d/d;->a()Lb/a/a/d/x;

    move-result-object v0

    invoke-interface {v0}, Lb/a/a/d/x;->a()I

    move-result v0

    invoke-direct {v1, v0}, Ljava/lang/StringBuffer;-><init>(I)V

    .line 584
    invoke-static {p1}, Lb/a/a/f;->a(Lb/a/a/z;)J

    move-result-wide v2

    invoke-static {p1}, Lb/a/a/f;->b(Lb/a/a/z;)Lb/a/a/a;

    move-result-object v4

    invoke-virtual {p0}, Lb/a/a/d/d;->a()Lb/a/a/d/x;

    move-result-object v0

    invoke-virtual {p0, v4}, Lb/a/a/d/d;->a(Lb/a/a/a;)Lb/a/a/a;

    move-result-object v8

    invoke-virtual {v8}, Lb/a/a/a;->a()Lb/a/a/i;

    move-result-object v7

    invoke-virtual {v7, v2, v3}, Lb/a/a/i;->b(J)I

    move-result v6

    int-to-long v4, v6

    add-long/2addr v4, v2

    xor-long v10, v2, v4

    cmp-long v9, v10, v12

    if-gez v9, :cond_0

    int-to-long v10, v6

    xor-long/2addr v10, v2

    cmp-long v9, v10, v12

    if-ltz v9, :cond_0

    sget-object v6, Lb/a/a/i;->a:Lb/a/a/i;

    const/4 v5, 0x0

    :goto_0
    invoke-virtual {v8}, Lb/a/a/a;->b()Lb/a/a/a;

    move-result-object v4

    iget-object v7, p0, Lb/a/a/d/d;->c:Ljava/util/Locale;

    invoke-interface/range {v0 .. v7}, Lb/a/a/d/x;->a(Ljava/lang/StringBuffer;JLb/a/a/a;ILb/a/a/i;Ljava/util/Locale;)V

    .line 585
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_0
    move-wide v2, v4

    move v5, v6

    move-object v6, v7

    goto :goto_0
.end method

.method public final b()Lb/a/a/d/t;
    .locals 2

    .prologue
    .line 927
    iget-object v0, p0, Lb/a/a/d/d;->b:Lb/a/a/d/t;

    .line 928
    if-nez v0, :cond_0

    .line 929
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "Parsing not supported"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 931
    :cond_0
    return-object v0
.end method
