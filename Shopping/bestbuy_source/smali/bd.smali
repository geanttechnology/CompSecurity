.class final Lbd;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lal;


# instance fields
.field private final a:Ljava/io/Writer;

.field private final e:Lbe;


# direct methods
.method constructor <init>(Ljava/io/Writer;)V
    .locals 1

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    iput-object p1, p0, Lbd;->a:Ljava/io/Writer;

    .line 23
    new-instance v0, Lbe;

    invoke-direct {v0, p0}, Lbe;-><init>(Lbd;)V

    iput-object v0, p0, Lbd;->e:Lbe;

    .line 24
    return-void
.end method

.method private a(Ljava/lang/StackTraceElement;)Lbd;
    .locals 4

    .prologue
    .line 86
    invoke-virtual {p0}, Lbd;->b()Lbd;

    move-result-object v0

    const-string v1, "c"

    invoke-virtual {p1}, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lbd;->a(Ljava/lang/String;Ljava/lang/String;)Lbd;

    move-result-object v0

    invoke-virtual {v0}, Lbd;->a()Lbd;

    move-result-object v0

    const-string v1, "m"

    invoke-virtual {p1}, Ljava/lang/StackTraceElement;->getMethodName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lbd;->a(Ljava/lang/String;Ljava/lang/String;)Lbd;

    move-result-object v0

    invoke-virtual {v0}, Lbd;->a()Lbd;

    move-result-object v0

    const-string v1, "f"

    invoke-virtual {p1}, Ljava/lang/StackTraceElement;->getFileName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lbd;->a(Ljava/lang/String;Ljava/lang/String;)Lbd;

    move-result-object v0

    invoke-virtual {v0}, Lbd;->a()Lbd;

    move-result-object v0

    const-string v1, "l"

    invoke-virtual {p1}, Ljava/lang/StackTraceElement;->getLineNumber()I

    move-result v2

    int-to-long v2, v2

    invoke-virtual {v0, v1, v2, v3}, Lbd;->a(Ljava/lang/String;J)Lbd;

    move-result-object v0

    invoke-virtual {v0}, Lbd;->c()Lbd;

    move-result-object v0

    return-object v0
.end method

.method private a(Ljava/lang/Throwable;IZ)Lbd;
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 31
    const/4 v0, 0x4

    if-le p2, v0, :cond_0

    .line 82
    :goto_0
    return-object p0

    .line 35
    :cond_0
    invoke-virtual {p0}, Lbd;->b()Lbd;

    move-result-object v0

    const-string v2, "exceptionClassName"

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lbd;->a(Ljava/lang/String;Ljava/lang/String;)Lbd;

    move-result-object v0

    invoke-virtual {v0}, Lbd;->a()Lbd;

    move-result-object v0

    const-string v2, "message"

    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lbd;->a(Ljava/lang/String;Ljava/lang/String;)Lbd;

    .line 40
    invoke-virtual {p1}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 41
    invoke-virtual {p0}, Lbd;->a()Lbd;

    move-result-object v0

    const-string v2, "cause"

    invoke-virtual {v0, v2}, Lbd;->a(Ljava/lang/String;)Lbd;

    .line 43
    iget-object v0, p0, Lbd;->a:Ljava/io/Writer;

    const-string v2, ": "

    invoke-virtual {v0, v2}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    .line 44
    invoke-virtual {p1}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    add-int/lit8 v2, p2, 0x1

    invoke-direct {p0, v0, v2, p3}, Lbd;->a(Ljava/lang/Throwable;IZ)Lbd;

    .line 49
    :cond_1
    invoke-virtual {p0}, Lbd;->a()Lbd;

    move-result-object v0

    const-string v2, "stackTraceElements"

    invoke-virtual {v0, v2}, Lbd;->a(Ljava/lang/String;)Lbd;

    .line 51
    iget-object v0, p0, Lbd;->a:Ljava/io/Writer;

    const-string v2, ": "

    invoke-virtual {v0, v2}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    .line 52
    invoke-virtual {p0}, Lbd;->d()Lbd;

    .line 53
    invoke-virtual {p1}, Ljava/lang/Throwable;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v2

    .line 54
    array-length v0, v2

    add-int/lit8 v3, v0, -0x1

    move v0, v1

    .line 56
    :goto_1
    if-ge v0, v3, :cond_2

    .line 57
    aget-object v4, v2, v0

    invoke-direct {p0, v4}, Lbd;->a(Ljava/lang/StackTraceElement;)Lbd;

    move-result-object v4

    invoke-virtual {v4}, Lbd;->a()Lbd;

    .line 56
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 61
    :cond_2
    aget-object v0, v2, v3

    invoke-direct {p0, v0}, Lbd;->a(Ljava/lang/StackTraceElement;)Lbd;

    .line 62
    invoke-virtual {p0}, Lbd;->e()Lbd;

    .line 65
    if-eqz p3, :cond_4

    .line 66
    invoke-static {p1}, Lbc;->a(Ljava/lang/Throwable;)[Ljava/lang/Throwable;

    move-result-object v2

    .line 67
    array-length v0, v2

    if-lez v0, :cond_4

    .line 68
    invoke-virtual {p0}, Lbd;->a()Lbd;

    move-result-object v0

    const-string v3, "suppressed"

    invoke-virtual {v0, v3}, Lbd;->a(Ljava/lang/String;)Lbd;

    .line 70
    iget-object v0, p0, Lbd;->a:Ljava/io/Writer;

    const-string v3, ":"

    invoke-virtual {v0, v3}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    .line 71
    invoke-virtual {p0}, Lbd;->d()Lbd;

    move v0, v1

    .line 72
    :goto_2
    array-length v3, v2

    add-int/lit8 v3, v3, -0x1

    if-ge v0, v3, :cond_3

    .line 73
    aget-object v3, v2, v0

    invoke-direct {p0, v3, v1, v1}, Lbd;->a(Ljava/lang/Throwable;IZ)Lbd;

    move-result-object v3

    invoke-virtual {v3}, Lbd;->a()Lbd;

    .line 72
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 77
    :cond_3
    array-length v0, v2

    add-int/lit8 v0, v0, -0x1

    aget-object v0, v2, v0

    invoke-direct {p0, v0, v1, v1}, Lbd;->a(Ljava/lang/Throwable;IZ)Lbd;

    .line 78
    invoke-virtual {p0}, Lbd;->e()Lbd;

    .line 82
    :cond_4
    invoke-virtual {p0}, Lbd;->c()Lbd;

    move-result-object p0

    goto/16 :goto_0
.end method

.method static synthetic a(Lbd;)Ljava/io/Writer;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lbd;->a:Ljava/io/Writer;

    return-object v0
.end method


# virtual methods
.method public final a()Lbd;
    .locals 2

    .prologue
    .line 99
    iget-object v0, p0, Lbd;->a:Ljava/io/Writer;

    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    .line 100
    return-object p0
.end method

.method public final a(Ljava/lang/String;)Lbd;
    .locals 2

    .prologue
    .line 124
    iget-object v0, p0, Lbd;->a:Ljava/io/Writer;

    const-string v1, "\""

    invoke-virtual {v0, v1}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    .line 125
    iget-object v0, p0, Lbd;->e:Lbe;

    invoke-virtual {v0, p1}, Lbe;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    .line 126
    iget-object v0, p0, Lbd;->a:Ljava/io/Writer;

    const-string v1, "\""

    invoke-virtual {v0, v1}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    .line 127
    return-object p0
.end method

.method public final a(Ljava/lang/String;J)Lbd;
    .locals 2

    .prologue
    .line 142
    iget-object v0, p0, Lbd;->a:Ljava/io/Writer;

    const-string v1, "\""

    invoke-virtual {v0, v1}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    move-result-object v0

    const-string v1, "\": "

    invoke-virtual {v0, v1}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    move-result-object v0

    invoke-static {p2, p3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    .line 146
    return-object p0
.end method

.method public final a(Ljava/lang/String;Ljava/lang/String;)Lbd;
    .locals 1

    .prologue
    .line 136
    invoke-virtual {p0, p1}, Lbd;->a(Ljava/lang/String;)Lbd;

    move-result-object v0

    invoke-virtual {v0}, Lbd;->f()Lbd;

    move-result-object v0

    if-nez p2, :cond_0

    const-string p2, ""

    :cond_0
    invoke-virtual {v0, p2}, Lbd;->a(Ljava/lang/String;)Lbd;

    move-result-object v0

    return-object v0
.end method

.method public final a(Ljava/lang/Throwable;Z)Lbd;
    .locals 2

    .prologue
    .line 27
    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-direct {p0, p1, v0, v1}, Lbd;->a(Ljava/lang/Throwable;IZ)Lbd;

    move-result-object v0

    return-object v0
.end method

.method public final b()Lbd;
    .locals 2

    .prologue
    .line 104
    iget-object v0, p0, Lbd;->a:Ljava/io/Writer;

    const-string v1, "{"

    invoke-virtual {v0, v1}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    .line 105
    return-object p0
.end method

.method public final c()Lbd;
    .locals 2

    .prologue
    .line 109
    iget-object v0, p0, Lbd;->a:Ljava/io/Writer;

    const-string v1, "}"

    invoke-virtual {v0, v1}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    .line 110
    return-object p0
.end method

.method public final d()Lbd;
    .locals 2

    .prologue
    .line 114
    iget-object v0, p0, Lbd;->a:Ljava/io/Writer;

    const-string v1, "["

    invoke-virtual {v0, v1}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    .line 115
    return-object p0
.end method

.method public final e()Lbd;
    .locals 2

    .prologue
    .line 119
    iget-object v0, p0, Lbd;->a:Ljava/io/Writer;

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    .line 120
    return-object p0
.end method

.method public final f()Lbd;
    .locals 2

    .prologue
    .line 131
    iget-object v0, p0, Lbd;->a:Ljava/io/Writer;

    const-string v1, ": "

    invoke-virtual {v0, v1}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    .line 132
    return-object p0
.end method
