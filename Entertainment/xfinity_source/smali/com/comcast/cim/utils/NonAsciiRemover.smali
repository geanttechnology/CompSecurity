.class public Lcom/comcast/cim/utils/NonAsciiRemover;
.super Ljava/lang/Object;
.source "NonAsciiRemover.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public convertNonAscii(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    .line 28
    if-nez p1, :cond_0

    .line 29
    const/4 v5, 0x0

    .line 43
    :goto_0
    return-object v5

    .line 31
    :cond_0
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 32
    .local v4, "sb":Ljava/lang/StringBuilder;
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    .line 33
    .local v2, "n":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    if-ge v1, v2, :cond_2

    .line 34
    invoke-virtual {p1, v1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 35
    .local v0, "c":C
    const-string v5, "\u00c0\u00e0\u00c8\u00e8\u00cc\u00ec\u00d2\u00f2\u00d9\u00f9\u00c1\u00e1\u00c9\u00e9\u00cd\u00ed\u00d3\u00f3\u00da\u00fa\u00dd\u00fd\u00c2\u00e2\u00ca\u00ea\u00ce\u00ee\u00d4\u00f4\u00db\u00fb\u0176\u0177\u00c3\u00e3\u00d5\u00f5\u00d1\u00f1\u00c4\u00e4\u00cb\u00eb\u00cf\u00ef\u00d6\u00f6\u00dc\u00fc\u0178\u00ff\u00c5\u00e5\u00c7\u00e7\u0150\u0151\u0170\u0171"

    invoke-virtual {v5, v0}, Ljava/lang/String;->indexOf(I)I

    move-result v3

    .line 36
    .local v3, "pos":I
    const/4 v5, -0x1

    if-le v3, v5, :cond_1

    .line 37
    const-string v5, "AaEeIiOoUuAaEeIiOoUuYyAaEeIiOoUuYyAaOoNnAaEeIiOoUuYyAaCcOoUu"

    invoke-virtual {v5, v3}, Ljava/lang/String;->charAt(I)C

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 33
    :goto_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 40
    :cond_1
    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_2

    .line 43
    .end local v0    # "c":C
    .end local v3    # "pos":I
    :cond_2
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    goto :goto_0
.end method
