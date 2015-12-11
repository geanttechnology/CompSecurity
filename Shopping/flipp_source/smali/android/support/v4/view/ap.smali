.class public final Landroid/support/v4/view/ap;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field static final a:Landroid/support/v4/view/az;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 1151
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 1152
    const/16 v1, 0x15

    if-lt v0, v1, :cond_0

    .line 1153
    new-instance v0, Landroid/support/v4/view/aq;

    invoke-direct {v0}, Landroid/support/v4/view/aq;-><init>()V

    sput-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    .line 1171
    :goto_0
    return-void

    .line 1154
    :cond_0
    const/16 v1, 0x13

    if-lt v0, v1, :cond_1

    .line 1155
    new-instance v0, Landroid/support/v4/view/ay;

    invoke-direct {v0}, Landroid/support/v4/view/ay;-><init>()V

    sput-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    goto :goto_0

    .line 1156
    :cond_1
    const/16 v1, 0x11

    if-lt v0, v1, :cond_2

    .line 1157
    new-instance v0, Landroid/support/v4/view/ax;

    invoke-direct {v0}, Landroid/support/v4/view/ax;-><init>()V

    sput-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    goto :goto_0

    .line 1158
    :cond_2
    const/16 v1, 0x10

    if-lt v0, v1, :cond_3

    .line 1159
    new-instance v0, Landroid/support/v4/view/aw;

    invoke-direct {v0}, Landroid/support/v4/view/aw;-><init>()V

    sput-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    goto :goto_0

    .line 1160
    :cond_3
    const/16 v1, 0xe

    if-lt v0, v1, :cond_4

    .line 1161
    new-instance v0, Landroid/support/v4/view/av;

    invoke-direct {v0}, Landroid/support/v4/view/av;-><init>()V

    sput-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    goto :goto_0

    .line 1162
    :cond_4
    const/16 v1, 0xb

    if-lt v0, v1, :cond_5

    .line 1163
    new-instance v0, Landroid/support/v4/view/au;

    invoke-direct {v0}, Landroid/support/v4/view/au;-><init>()V

    sput-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    goto :goto_0

    .line 1164
    :cond_5
    const/16 v1, 0x9

    if-lt v0, v1, :cond_6

    .line 1165
    new-instance v0, Landroid/support/v4/view/at;

    invoke-direct {v0}, Landroid/support/v4/view/at;-><init>()V

    sput-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    goto :goto_0

    .line 1166
    :cond_6
    const/4 v1, 0x7

    if-lt v0, v1, :cond_7

    .line 1167
    new-instance v0, Landroid/support/v4/view/as;

    invoke-direct {v0}, Landroid/support/v4/view/as;-><init>()V

    sput-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    goto :goto_0

    .line 1169
    :cond_7
    new-instance v0, Landroid/support/v4/view/ar;

    invoke-direct {v0}, Landroid/support/v4/view/ar;-><init>()V

    sput-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    goto :goto_0
.end method

.method public static a(Landroid/view/View;)I
    .locals 1

    .prologue
    .line 1206
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0}, Landroid/support/v4/view/az;->a(Landroid/view/View;)I

    move-result v0

    return v0
.end method

.method public static a(Landroid/view/View;F)V
    .locals 1

    .prologue
    .line 1946
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0, p1}, Landroid/support/v4/view/az;->a(Landroid/view/View;F)V

    .line 1947
    return-void
.end method

.method public static a(Landroid/view/View;IIII)V
    .locals 6

    .prologue
    .line 1407
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    move-object v1, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    invoke-interface/range {v0 .. v5}, Landroid/support/v4/view/az;->a(Landroid/view/View;IIII)V

    .line 1408
    return-void
.end method

.method public static a(Landroid/view/View;ILandroid/graphics/Paint;)V
    .locals 1

    .prologue
    .line 1579
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0, p1, p2}, Landroid/support/v4/view/az;->a(Landroid/view/View;ILandroid/graphics/Paint;)V

    .line 1580
    return-void
.end method

.method public static a(Landroid/view/View;Landroid/graphics/Paint;)V
    .locals 1

    .prologue
    .line 1656
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0, p1}, Landroid/support/v4/view/az;->a(Landroid/view/View;Landroid/graphics/Paint;)V

    .line 1657
    return-void
.end method

.method public static a(Landroid/view/View;Landroid/support/v4/view/a;)V
    .locals 1

    .prologue
    .line 1343
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0, p1}, Landroid/support/v4/view/az;->a(Landroid/view/View;Landroid/support/v4/view/a;)V

    .line 1344
    return-void
.end method

.method public static a(Landroid/view/View;Ljava/lang/Runnable;)V
    .locals 1

    .prologue
    .line 1421
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0, p1}, Landroid/support/v4/view/az;->a(Landroid/view/View;Ljava/lang/Runnable;)V

    .line 1422
    return-void
.end method

.method public static a(Landroid/view/View;Ljava/lang/Runnable;J)V
    .locals 2

    .prologue
    .line 1438
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0, p1, p2, p3}, Landroid/support/v4/view/az;->a(Landroid/view/View;Ljava/lang/Runnable;J)V

    .line 1439
    return-void
.end method

.method public static a(Landroid/view/View;I)Z
    .locals 1

    .prologue
    .line 1181
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0, p1}, Landroid/support/v4/view/az;->a(Landroid/view/View;I)Z

    move-result v0

    return v0
.end method

.method public static b(Landroid/view/View;F)V
    .locals 1

    .prologue
    .line 1962
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0, p1}, Landroid/support/v4/view/az;->b(Landroid/view/View;F)V

    .line 1963
    return-void
.end method

.method public static b(Landroid/view/View;)Z
    .locals 1

    .prologue
    .line 1353
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0}, Landroid/support/v4/view/az;->b(Landroid/view/View;)Z

    move-result v0

    return v0
.end method

.method public static b(Landroid/view/View;I)Z
    .locals 1

    .prologue
    .line 1192
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0, p1}, Landroid/support/v4/view/az;->b(Landroid/view/View;I)Z

    move-result v0

    return v0
.end method

.method public static c(Landroid/view/View;F)V
    .locals 1

    .prologue
    .line 1978
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0, p1}, Landroid/support/v4/view/az;->c(Landroid/view/View;F)V

    .line 1979
    return-void
.end method

.method public static c(Landroid/view/View;I)V
    .locals 1

    .prologue
    .line 1480
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0, p1}, Landroid/support/v4/view/az;->c(Landroid/view/View;I)V

    .line 1481
    return-void
.end method

.method public static c(Landroid/view/View;)Z
    .locals 1

    .prologue
    .line 1365
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0}, Landroid/support/v4/view/az;->c(Landroid/view/View;)Z

    move-result v0

    return v0
.end method

.method public static d(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 1389
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0}, Landroid/support/v4/view/az;->d(Landroid/view/View;)V

    .line 1390
    return-void
.end method

.method public static e(Landroid/view/View;)I
    .locals 1

    .prologue
    .line 1456
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0}, Landroid/support/v4/view/az;->e(Landroid/view/View;)I

    move-result v0

    return v0
.end method

.method public static f(Landroid/view/View;)F
    .locals 1

    .prologue
    .line 1536
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0}, Landroid/support/v4/view/az;->f(Landroid/view/View;)F

    move-result v0

    return v0
.end method

.method public static g(Landroid/view/View;)I
    .locals 1

    .prologue
    .line 1600
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0}, Landroid/support/v4/view/az;->g(Landroid/view/View;)I

    move-result v0

    return v0
.end method

.method public static h(Landroid/view/View;)I
    .locals 1

    .prologue
    .line 1671
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0}, Landroid/support/v4/view/az;->h(Landroid/view/View;)I

    move-result v0

    return v0
.end method

.method public static i(Landroid/view/View;)Landroid/view/ViewParent;
    .locals 1

    .prologue
    .line 1703
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0}, Landroid/support/v4/view/az;->i(Landroid/view/View;)Landroid/view/ViewParent;

    move-result-object v0

    return-object v0
.end method

.method public static j(Landroid/view/View;)Z
    .locals 1

    .prologue
    .line 1716
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0}, Landroid/support/v4/view/az;->j(Landroid/view/View;)Z

    move-result v0

    return v0
.end method

.method public static k(Landroid/view/View;)F
    .locals 1

    .prologue
    .line 1885
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0}, Landroid/support/v4/view/az;->k(Landroid/view/View;)F

    move-result v0

    return v0
.end method

.method public static l(Landroid/view/View;)F
    .locals 1

    .prologue
    .line 1898
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0}, Landroid/support/v4/view/az;->l(Landroid/view/View;)F

    move-result v0

    return v0
.end method

.method public static m(Landroid/view/View;)I
    .locals 1

    .prologue
    .line 1909
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0}, Landroid/support/v4/view/az;->m(Landroid/view/View;)I

    move-result v0

    return v0
.end method

.method public static n(Landroid/view/View;)I
    .locals 1

    .prologue
    .line 1920
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0}, Landroid/support/v4/view/az;->n(Landroid/view/View;)I

    move-result v0

    return v0
.end method

.method public static o(Landroid/view/View;)Landroid/support/v4/view/cj;
    .locals 1

    .prologue
    .line 1932
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0}, Landroid/support/v4/view/az;->o(Landroid/view/View;)Landroid/support/v4/view/cj;

    move-result-object v0

    return-object v0
.end method

.method public static p(Landroid/view/View;)Z
    .locals 1

    .prologue
    .line 2242
    sget-object v0, Landroid/support/v4/view/ap;->a:Landroid/support/v4/view/az;

    invoke-interface {v0, p0}, Landroid/support/v4/view/az;->p(Landroid/view/View;)Z

    move-result v0

    return v0
.end method
