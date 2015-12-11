.class final Lmi;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final a:Ljava/lang/String;

.field private static final b:Ljava/util/regex/Pattern;


# instance fields
.field private final c:Landroid/content/Context;

.field private d:Landroid/graphics/Point;

.field private e:Landroid/graphics/Point;

.field private f:I

.field private g:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    const-class v0, Lmi;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lmi;->a:Ljava/lang/String;

    .line 35
    const-string v0, ","

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lmi;->b:Ljava/util/regex/Pattern;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    iput-object p1, p0, Lmi;->c:Landroid/content/Context;

    .line 45
    return-void
.end method

.method private static a(Ljava/lang/CharSequence;I)I
    .locals 10

    .prologue
    const/4 v0, 0x0

    .line 172
    .line 173
    sget-object v1, Lmi;->b:Ljava/util/regex/Pattern;

    invoke-virtual {v1, p0}, Ljava/util/regex/Pattern;->split(Ljava/lang/CharSequence;)[Ljava/lang/String;

    move-result-object v3

    array-length v4, v3

    move v2, v0

    move v1, v0

    :goto_0
    if-ge v2, v4, :cond_0

    aget-object v0, v3, v2

    .line 175
    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 178
    :try_start_0
    invoke-static {v0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v6

    .line 182
    const-wide/high16 v8, 0x4024000000000000L    # 10.0

    mul-double/2addr v8, v6

    double-to-int v0, v8

    .line 183
    int-to-double v8, p1

    sub-double v6, v8, v6

    invoke-static {v6, v7}, Ljava/lang/Math;->abs(D)D

    move-result-wide v6

    sub-int v5, p1, v1

    invoke-static {v5}, Ljava/lang/Math;->abs(I)I

    move-result v5

    int-to-double v8, v5

    cmpg-double v5, v6, v8

    if-gez v5, :cond_1

    .line 173
    :goto_1
    add-int/lit8 v1, v2, 0x1

    move v2, v1

    move v1, v0

    goto :goto_0

    :cond_0
    move p1, v1

    .line 187
    :goto_2
    return p1

    .line 179
    :catch_0
    move-exception v0

    goto :goto_2

    :cond_1
    move v0, v1

    goto :goto_1
.end method

.method private static a(Landroid/hardware/Camera$Parameters;Landroid/graphics/Point;)Landroid/graphics/Point;
    .locals 3

    .prologue
    .line 105
    const-string v0, "preview-size-values"

    invoke-virtual {p0, v0}, Landroid/hardware/Camera$Parameters;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 108
    if-nez v0, :cond_2

    .line 109
    const-string v0, "preview-size-value"

    invoke-virtual {p0, v0}, Landroid/hardware/Camera$Parameters;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    .line 112
    :goto_0
    const/4 v0, 0x0

    .line 114
    if-eqz v1, :cond_0

    .line 116
    invoke-static {v1, p1}, Lmi;->a(Ljava/lang/CharSequence;Landroid/graphics/Point;)Landroid/graphics/Point;

    move-result-object v0

    .line 119
    :cond_0
    if-nez v0, :cond_1

    .line 121
    new-instance v0, Landroid/graphics/Point;

    iget v1, p1, Landroid/graphics/Point;->x:I

    shr-int/lit8 v1, v1, 0x3

    shl-int/lit8 v1, v1, 0x3

    iget v2, p1, Landroid/graphics/Point;->y:I

    shr-int/lit8 v2, v2, 0x3

    shl-int/lit8 v2, v2, 0x3

    invoke-direct {v0, v1, v2}, Landroid/graphics/Point;-><init>(II)V

    .line 126
    :cond_1
    return-object v0

    :cond_2
    move-object v1, v0

    goto :goto_0
.end method

.method private static a(Ljava/lang/CharSequence;Landroid/graphics/Point;)Landroid/graphics/Point;
    .locals 10

    .prologue
    const/4 v0, 0x0

    .line 130
    .line 132
    const v1, 0x7fffffff

    .line 133
    sget-object v2, Lmi;->b:Ljava/util/regex/Pattern;

    invoke-virtual {v2, p0}, Ljava/util/regex/Pattern;->split(Ljava/lang/CharSequence;)[Ljava/lang/String;

    move-result-object v7

    array-length v8, v7

    move v6, v0

    move v2, v0

    move v4, v0

    move v0, v1

    :goto_0
    if-ge v6, v8, :cond_4

    aget-object v1, v7, v6

    .line 135
    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 136
    const/16 v3, 0x78

    invoke-virtual {v1, v3}, Ljava/lang/String;->indexOf(I)I

    move-result v3

    .line 137
    if-gez v3, :cond_0

    move v1, v2

    move v2, v4

    .line 133
    :goto_1
    add-int/lit8 v3, v6, 0x1

    move v6, v3

    move v4, v2

    move v2, v1

    goto :goto_0

    .line 145
    :cond_0
    const/4 v5, 0x0

    :try_start_0
    invoke-virtual {v1, v5, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v5

    .line 146
    add-int/lit8 v3, v3, 0x1

    invoke-virtual {v1, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    .line 152
    iget v1, p1, Landroid/graphics/Point;->x:I

    sub-int v1, v5, v1

    invoke-static {v1}, Ljava/lang/Math;->abs(I)I

    move-result v1

    iget v9, p1, Landroid/graphics/Point;->y:I

    sub-int v9, v3, v9

    invoke-static {v9}, Ljava/lang/Math;->abs(I)I

    move-result v9

    add-int/2addr v1, v9

    .line 153
    if-nez v1, :cond_1

    .line 165
    :goto_2
    if-lez v5, :cond_2

    if-lez v3, :cond_2

    .line 166
    new-instance v0, Landroid/graphics/Point;

    invoke-direct {v0, v5, v3}, Landroid/graphics/Point;-><init>(II)V

    .line 168
    :goto_3
    return-object v0

    .line 147
    :catch_0
    move-exception v1

    move v1, v2

    move v2, v4

    .line 149
    goto :goto_1

    .line 157
    :cond_1
    if-ge v1, v0, :cond_3

    move v0, v1

    move v2, v5

    move v1, v3

    .line 160
    goto :goto_1

    .line 168
    :cond_2
    const/4 v0, 0x0

    goto :goto_3

    :cond_3
    move v1, v2

    move v2, v4

    goto :goto_1

    :cond_4
    move v3, v2

    move v5, v4

    goto :goto_2
.end method

.method private a(Landroid/hardware/Camera$Parameters;)V
    .locals 2

    .prologue
    .line 196
    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v1, "Behold II"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget v0, Lmj;->a:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_0

    .line 197
    const-string v0, "flash-value"

    const/4 v1, 0x1

    invoke-virtual {p1, v0, v1}, Landroid/hardware/Camera$Parameters;->set(Ljava/lang/String;I)V

    .line 202
    :goto_0
    const-string v0, "flash-mode"

    const-string v1, "off"

    invoke-virtual {p1, v0, v1}, Landroid/hardware/Camera$Parameters;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 203
    return-void

    .line 199
    :cond_0
    const-string v0, "flash-value"

    const/4 v1, 0x2

    invoke-virtual {p1, v0, v1}, Landroid/hardware/Camera$Parameters;->set(Ljava/lang/String;I)V

    goto :goto_0
.end method

.method private b(Landroid/hardware/Camera$Parameters;)V
    .locals 8

    .prologue
    const-wide/high16 v6, 0x4024000000000000L    # 10.0

    .line 207
    const-string v0, "zoom-supported"

    invoke-virtual {p1, v0}, Landroid/hardware/Camera$Parameters;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 208
    if-eqz v0, :cond_1

    invoke-static {v0}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 267
    :cond_0
    :goto_0
    return-void

    .line 212
    :cond_1
    const/16 v1, 0x1b

    .line 214
    const-string v0, "max-zoom"

    invoke-virtual {p1, v0}, Landroid/hardware/Camera$Parameters;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 215
    if-eqz v2, :cond_2

    .line 217
    :try_start_0
    invoke-static {v2}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v4

    mul-double/2addr v4, v6

    double-to-int v0, v4

    .line 218
    if-le v1, v0, :cond_8

    :goto_1
    move v1, v0

    .line 226
    :cond_2
    :goto_2
    const-string v0, "taking-picture-zoom-max"

    invoke-virtual {p1, v0}, Landroid/hardware/Camera$Parameters;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 227
    if-eqz v3, :cond_3

    .line 229
    :try_start_1
    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_1

    move-result v0

    .line 230
    if-le v1, v0, :cond_3

    move v1, v0

    .line 238
    :cond_3
    :goto_3
    const-string v0, "mot-zoom-values"

    invoke-virtual {p1, v0}, Landroid/hardware/Camera$Parameters;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 239
    if-eqz v0, :cond_4

    .line 240
    invoke-static {v0, v1}, Lmi;->a(Ljava/lang/CharSequence;I)I

    move-result v1

    .line 243
    :cond_4
    const-string v4, "mot-zoom-step"

    invoke-virtual {p1, v4}, Landroid/hardware/Camera$Parameters;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 244
    if-eqz v4, :cond_5

    .line 246
    :try_start_2
    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v4

    .line 247
    mul-double/2addr v4, v6

    double-to-int v4, v4

    .line 248
    const/4 v5, 0x1

    if-le v4, v5, :cond_5

    .line 249
    rem-int v4, v1, v4
    :try_end_2
    .catch Ljava/lang/NumberFormatException; {:try_start_2 .. :try_end_2} :catch_2

    sub-int/2addr v1, v4

    .line 258
    :cond_5
    :goto_4
    if-nez v2, :cond_6

    if-eqz v0, :cond_7

    .line 259
    :cond_6
    const-string v0, "zoom"

    int-to-double v4, v1

    div-double/2addr v4, v6

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v0, v2}, Landroid/hardware/Camera$Parameters;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 264
    :cond_7
    if-eqz v3, :cond_0

    .line 265
    const-string v0, "taking-picture-zoom"

    invoke-virtual {p1, v0, v1}, Landroid/hardware/Camera$Parameters;->set(Ljava/lang/String;I)V

    goto :goto_0

    .line 221
    :catch_0
    move-exception v0

    goto :goto_2

    .line 233
    :catch_1
    move-exception v0

    goto :goto_3

    .line 251
    :catch_2
    move-exception v4

    goto :goto_4

    :cond_8
    move v0, v1

    goto :goto_1
.end method


# virtual methods
.method a()Landroid/graphics/Point;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lmi;->e:Landroid/graphics/Point;

    return-object v0
.end method

.method a(Landroid/hardware/Camera;)V
    .locals 4

    .prologue
    .line 52
    invoke-virtual {p1}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v1

    .line 53
    invoke-virtual {v1}, Landroid/hardware/Camera$Parameters;->getPreviewFormat()I

    move-result v0

    iput v0, p0, Lmi;->f:I

    .line 54
    const-string v0, "preview-format"

    invoke-virtual {v1, v0}, Landroid/hardware/Camera$Parameters;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lmi;->g:Ljava/lang/String;

    .line 56
    iget-object v0, p0, Lmi;->c:Landroid/content/Context;

    const-string v2, "window"

    invoke-virtual {v0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    .line 57
    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    .line 58
    new-instance v2, Landroid/graphics/Point;

    invoke-virtual {v0}, Landroid/view/Display;->getWidth()I

    move-result v3

    invoke-virtual {v0}, Landroid/view/Display;->getHeight()I

    move-result v0

    invoke-direct {v2, v3, v0}, Landroid/graphics/Point;-><init>(II)V

    iput-object v2, p0, Lmi;->d:Landroid/graphics/Point;

    .line 60
    iget-object v0, p0, Lmi;->d:Landroid/graphics/Point;

    invoke-static {v1, v0}, Lmi;->a(Landroid/hardware/Camera$Parameters;Landroid/graphics/Point;)Landroid/graphics/Point;

    move-result-object v0

    iput-object v0, p0, Lmi;->e:Landroid/graphics/Point;

    .line 62
    return-void
.end method

.method b()Landroid/graphics/Point;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lmi;->d:Landroid/graphics/Point;

    return-object v0
.end method

.method b(Landroid/hardware/Camera;)V
    .locals 3

    .prologue
    .line 72
    invoke-virtual {p1}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v0

    .line 74
    iget-object v1, p0, Lmi;->e:Landroid/graphics/Point;

    iget v1, v1, Landroid/graphics/Point;->x:I

    iget-object v2, p0, Lmi;->e:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->y:I

    invoke-virtual {v0, v1, v2}, Landroid/hardware/Camera$Parameters;->setPreviewSize(II)V

    .line 75
    const-string v1, "orientation"

    const-string v2, "portrait"

    invoke-virtual {v0, v1, v2}, Landroid/hardware/Camera$Parameters;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 78
    invoke-direct {p0, v0}, Lmi;->a(Landroid/hardware/Camera$Parameters;)V

    .line 79
    invoke-direct {p0, v0}, Lmi;->b(Landroid/hardware/Camera$Parameters;)V

    .line 81
    invoke-virtual {p1, v0}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V

    .line 82
    const/16 v0, 0x5a

    invoke-virtual {p1, v0}, Landroid/hardware/Camera;->setDisplayOrientation(I)V

    .line 85
    return-void
.end method

.method c()I
    .locals 1

    .prologue
    .line 96
    iget v0, p0, Lmi;->f:I

    return v0
.end method

.method d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lmi;->g:Ljava/lang/String;

    return-object v0
.end method
