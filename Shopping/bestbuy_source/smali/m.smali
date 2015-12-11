.class final Lm;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field final a:Lam;

.field final b:Ljava/net/URL;

.field final c:Ljava/net/URL;

.field private d:Ljava/net/URL;

.field private e:Ljava/net/URL;

.field private f:Lf;


# direct methods
.method private constructor <init>(Ljava/net/URL;Ljava/net/URL;Ljava/net/URL;Ljava/net/URL;Lam;Lf;)V
    .locals 0

    .prologue
    .line 793
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 794
    iput-object p1, p0, Lm;->b:Ljava/net/URL;

    .line 795
    iput-object p2, p0, Lm;->c:Ljava/net/URL;

    .line 796
    iput-object p3, p0, Lm;->d:Ljava/net/URL;

    .line 797
    iput-object p4, p0, Lm;->e:Ljava/net/URL;

    .line 798
    iput-object p6, p0, Lm;->f:Lf;

    .line 799
    iput-object p5, p0, Lm;->a:Lam;

    .line 800
    return-void
.end method

.method private a(Le;)Le;
    .locals 1

    .prologue
    const/16 v0, 0x7530

    .line 833
    invoke-virtual {p1, v0}, Le;->a(I)V

    .line 834
    invoke-virtual {p1, v0}, Le;->b(I)V

    .line 835
    iget-object v0, p0, Lm;->a:Lam;

    invoke-virtual {v0, p1}, Lam;->a(Le;)V

    .line 836
    return-object p1
.end method

.method private static a(Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 841
    :try_start_0
    const-string v0, "utf-8"

    invoke-static {p0, v0}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    .line 842
    :catch_0
    move-exception v0

    .line 843
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method static synthetic a(Ljava/lang/String;Ljava/lang/String;Lam;Lf;)Lm;
    .locals 7

    .prologue
    .line 763
    new-instance v3, Ljava/net/URL;

    invoke-direct {v3, p0}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    new-instance v5, Ljava/net/URL;

    invoke-direct {v5, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    new-instance v0, Lm;

    new-instance v1, Ljava/net/URL;

    const-string v2, "/eumcollector/mobileMetrics?version=2"

    invoke-direct {v1, v3, v2}, Ljava/net/URL;-><init>(Ljava/net/URL;Ljava/lang/String;)V

    new-instance v2, Ljava/net/URL;

    const-string v4, "/eumcollector/mobileAgentCount"

    invoke-direct {v2, v3, v4}, Ljava/net/URL;-><init>(Ljava/net/URL;Ljava/lang/String;)V

    new-instance v3, Ljava/net/URL;

    const-string v4, "/dexgen/infopoint"

    invoke-direct {v3, v5, v4}, Ljava/net/URL;-><init>(Ljava/net/URL;Ljava/lang/String;)V

    new-instance v4, Ljava/net/URL;

    const-string v6, "/dexgen/infopoint/dex"

    invoke-direct {v4, v5, v6}, Ljava/net/URL;-><init>(Ljava/net/URL;Ljava/lang/String;)V

    move-object v5, p2

    move-object v6, p3

    invoke-direct/range {v0 .. v6}, Lm;-><init>(Ljava/net/URL;Ljava/net/URL;Ljava/net/URL;Ljava/net/URL;Lam;Lf;)V

    return-object v0
.end method


# virtual methods
.method public final a()Le;
    .locals 2

    .prologue
    .line 803
    iget-object v0, p0, Lm;->f:Lf;

    invoke-interface {v0}, Lf;->a()Le;

    move-result-object v0

    .line 804
    iget-object v1, p0, Lm;->c:Ljava/net/URL;

    invoke-virtual {v0, v1}, Le;->a(Ljava/net/URL;)V

    .line 805
    const-string v1, "POST"

    invoke-virtual {v0, v1}, Le;->a(Ljava/lang/String;)V

    .line 806
    invoke-direct {p0, v0}, Lm;->a(Le;)Le;

    move-result-object v0

    return-object v0
.end method

.method public final b()Le;
    .locals 2

    .prologue
    .line 810
    iget-object v0, p0, Lm;->f:Lf;

    invoke-interface {v0}, Lf;->a()Le;

    move-result-object v0

    .line 811
    iget-object v1, p0, Lm;->b:Ljava/net/URL;

    invoke-virtual {v0, v1}, Le;->a(Ljava/net/URL;)V

    .line 812
    const-string v1, "POST"

    invoke-virtual {v0, v1}, Le;->a(Ljava/lang/String;)V

    .line 813
    invoke-direct {p0, v0}, Lm;->a(Le;)Le;

    move-result-object v0

    return-object v0
.end method

.method public final c()Le;
    .locals 5

    .prologue
    .line 817
    iget-object v0, p0, Lm;->f:Lf;

    invoke-interface {v0}, Lf;->a()Le;

    move-result-object v0

    .line 818
    new-instance v1, Ljava/net/URL;

    iget-object v2, p0, Lm;->e:Ljava/net/URL;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "?av="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lm;->a:Lam;

    invoke-virtual {v4}, Lam;->a()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lm;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Ljava/net/URL;-><init>(Ljava/net/URL;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Le;->a(Ljava/net/URL;)V

    .line 820
    const-string v1, "GET"

    invoke-virtual {v0, v1}, Le;->a(Ljava/lang/String;)V

    .line 821
    invoke-direct {p0, v0}, Lm;->a(Le;)Le;

    move-result-object v0

    return-object v0
.end method

.method public final d()Le;
    .locals 5

    .prologue
    .line 825
    iget-object v0, p0, Lm;->f:Lf;

    invoke-interface {v0}, Lf;->a()Le;

    move-result-object v0

    .line 826
    new-instance v1, Ljava/net/URL;

    iget-object v2, p0, Lm;->d:Ljava/net/URL;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "?av="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lm;->a:Lam;

    invoke-virtual {v4}, Lam;->a()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lm;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Ljava/net/URL;-><init>(Ljava/net/URL;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Le;->a(Ljava/net/URL;)V

    .line 828
    const-string v1, "GET"

    invoke-virtual {v0, v1}, Le;->a(Ljava/lang/String;)V

    .line 829
    invoke-direct {p0, v0}, Lm;->a(Le;)Le;

    move-result-object v0

    return-object v0
.end method
