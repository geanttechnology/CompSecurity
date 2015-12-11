.class public final Lmj;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field static final a:I

.field private static final b:Ljava/lang/String;

.field private static c:Lmj;


# instance fields
.field private final d:Landroid/content/Context;

.field private final e:Lmi;

.field private f:Landroid/hardware/Camera;

.field private g:Landroid/graphics/Rect;

.field private h:Landroid/graphics/Rect;

.field private i:Z

.field private j:Z

.field private final k:Z

.field private final l:Lml;

.field private final m:Lmh;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lmj;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lmj;->b:Ljava/lang/String;

    .line 34
    :try_start_0
    sget-object v0, Landroid/os/Build$VERSION;->SDK:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 38
    :goto_0
    sput v0, Lmj;->a:I

    .line 39
    return-void

    .line 35
    :catch_0
    move-exception v0

    .line 36
    const/16 v0, 0x2710

    goto :goto_0
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 3

    .prologue
    .line 86
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 89
    iput-object p1, p0, Lmj;->d:Landroid/content/Context;

    .line 90
    new-instance v0, Lmi;

    invoke-direct {v0, p1}, Lmi;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lmj;->e:Lmi;

    .line 92
    sget-object v0, Landroid/os/Build$VERSION;->SDK:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    const/4 v1, 0x3

    if-le v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lmj;->k:Z

    .line 94
    new-instance v0, Lml;

    iget-object v1, p0, Lmj;->e:Lmi;

    iget-boolean v2, p0, Lmj;->k:Z

    invoke-direct {v0, v1, v2}, Lml;-><init>(Lmi;Z)V

    iput-object v0, p0, Lmj;->l:Lml;

    .line 96
    new-instance v0, Lmh;

    invoke-direct {v0}, Lmh;-><init>()V

    iput-object v0, p0, Lmj;->m:Lmh;

    .line 97
    return-void

    .line 92
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static a()Lmj;
    .locals 1

    .prologue
    .line 83
    sget-object v0, Lmj;->c:Lmj;

    return-object v0
.end method

.method public static a(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 71
    sget-object v0, Lmj;->c:Lmj;

    if-nez v0, :cond_0

    .line 72
    new-instance v0, Lmj;

    invoke-direct {v0, p0}, Lmj;-><init>(Landroid/content/Context;)V

    sput-object v0, Lmj;->c:Lmj;

    .line 74
    :cond_0
    return-void
.end method


# virtual methods
.method public a([BII)Lme;
    .locals 8

    .prologue
    .line 298
    invoke-virtual {p0}, Lmj;->h()Landroid/graphics/Rect;

    move-result-object v1

    .line 300
    iget-object v0, p0, Lmj;->e:Lmi;

    invoke-virtual {v0}, Lmi;->c()I

    move-result v0

    .line 301
    iget-object v2, p0, Lmj;->e:Lmi;

    invoke-virtual {v2}, Lmi;->d()Ljava/lang/String;

    move-result-object v2

    .line 302
    packed-switch v0, :pswitch_data_0

    .line 318
    const-string v3, "yuv420p"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 319
    new-instance v0, Lme;

    iget v4, v1, Landroid/graphics/Rect;->left:I

    iget v5, v1, Landroid/graphics/Rect;->top:I

    invoke-virtual {v1}, Landroid/graphics/Rect;->width()I

    move-result v6

    invoke-virtual {v1}, Landroid/graphics/Rect;->height()I

    move-result v7

    move-object v1, p1

    move v2, p2

    move v3, p3

    invoke-direct/range {v0 .. v7}, Lme;-><init>([BIIIIII)V

    :goto_0
    return-object v0

    .line 311
    :pswitch_0
    new-instance v0, Lme;

    iget v4, v1, Landroid/graphics/Rect;->left:I

    iget v5, v1, Landroid/graphics/Rect;->top:I

    invoke-virtual {v1}, Landroid/graphics/Rect;->width()I

    move-result v6

    invoke-virtual {v1}, Landroid/graphics/Rect;->height()I

    move-result v7

    move-object v1, p1

    move v2, p2

    move v3, p3

    invoke-direct/range {v0 .. v7}, Lme;-><init>([BIIIIII)V

    goto :goto_0

    .line 323
    :cond_0
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unsupported picture format: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v3, 0x2f

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 302
    :pswitch_data_0
    .packed-switch 0x10
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method public a(Landroid/os/Handler;I)V
    .locals 2

    .prologue
    .line 200
    iget-object v0, p0, Lmj;->f:Landroid/hardware/Camera;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lmj;->j:Z

    if-eqz v0, :cond_0

    .line 201
    iget-object v0, p0, Lmj;->l:Lml;

    invoke-virtual {v0, p1, p2}, Lml;->a(Landroid/os/Handler;I)V

    .line 202
    iget-boolean v0, p0, Lmj;->k:Z

    if-eqz v0, :cond_1

    .line 203
    iget-object v0, p0, Lmj;->f:Landroid/hardware/Camera;

    iget-object v1, p0, Lmj;->l:Lml;

    invoke-virtual {v0, v1}, Landroid/hardware/Camera;->setOneShotPreviewCallback(Landroid/hardware/Camera$PreviewCallback;)V

    .line 208
    :cond_0
    :goto_0
    return-void

    .line 205
    :cond_1
    iget-object v0, p0, Lmj;->f:Landroid/hardware/Camera;

    iget-object v1, p0, Lmj;->l:Lml;

    invoke-virtual {v0, v1}, Landroid/hardware/Camera;->setPreviewCallback(Landroid/hardware/Camera$PreviewCallback;)V

    goto :goto_0
.end method

.method public a(Landroid/view/SurfaceHolder;)V
    .locals 2

    .prologue
    .line 111
    iget-object v0, p0, Lmj;->f:Landroid/hardware/Camera;

    if-nez v0, :cond_2

    .line 112
    invoke-static {}, Landroid/hardware/Camera;->open()Landroid/hardware/Camera;

    move-result-object v0

    iput-object v0, p0, Lmj;->f:Landroid/hardware/Camera;

    .line 113
    iget-object v0, p0, Lmj;->f:Landroid/hardware/Camera;

    if-nez v0, :cond_0

    .line 114
    new-instance v0, Ljava/io/IOException;

    invoke-direct {v0}, Ljava/io/IOException;-><init>()V

    throw v0

    .line 116
    :cond_0
    iget-object v0, p0, Lmj;->f:Landroid/hardware/Camera;

    invoke-virtual {v0, p1}, Landroid/hardware/Camera;->setPreviewDisplay(Landroid/view/SurfaceHolder;)V

    .line 118
    iget-boolean v0, p0, Lmj;->i:Z

    if-nez v0, :cond_1

    .line 119
    const/4 v0, 0x1

    iput-boolean v0, p0, Lmj;->i:Z

    .line 120
    iget-object v0, p0, Lmj;->e:Lmi;

    iget-object v1, p0, Lmj;->f:Landroid/hardware/Camera;

    invoke-virtual {v0, v1}, Lmi;->a(Landroid/hardware/Camera;)V

    .line 122
    :cond_1
    iget-object v0, p0, Lmj;->e:Lmi;

    iget-object v1, p0, Lmj;->f:Landroid/hardware/Camera;

    invoke-virtual {v0, v1}, Lmi;->b(Landroid/hardware/Camera;)V

    .line 126
    :cond_2
    return-void
.end method

.method public b([BII)Lme;
    .locals 8

    .prologue
    .line 331
    invoke-virtual {p0}, Lmj;->h()Landroid/graphics/Rect;

    move-result-object v1

    .line 332
    iget-object v0, p0, Lmj;->e:Lmi;

    invoke-virtual {v0}, Lmi;->c()I

    move-result v0

    .line 333
    iget-object v2, p0, Lmj;->e:Lmi;

    invoke-virtual {v2}, Lmi;->d()Ljava/lang/String;

    move-result-object v2

    .line 334
    packed-switch v0, :pswitch_data_0

    .line 350
    const-string v3, "yuv420p"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 351
    new-instance v0, Lme;

    iget v4, v1, Landroid/graphics/Rect;->left:I

    iget v5, v1, Landroid/graphics/Rect;->top:I

    invoke-virtual {v1}, Landroid/graphics/Rect;->width()I

    move-result v6

    invoke-virtual {v1}, Landroid/graphics/Rect;->height()I

    move-result v7

    move-object v1, p1

    move v2, p2

    move v3, p3

    invoke-direct/range {v0 .. v7}, Lme;-><init>([BIIIIII)V

    :goto_0
    return-object v0

    .line 343
    :pswitch_0
    new-instance v0, Lme;

    iget v4, v1, Landroid/graphics/Rect;->left:I

    iget v5, v1, Landroid/graphics/Rect;->top:I

    invoke-virtual {v1}, Landroid/graphics/Rect;->width()I

    move-result v6

    invoke-virtual {v1}, Landroid/graphics/Rect;->height()I

    move-result v7

    move-object v1, p1

    move v2, p2

    move v3, p3

    invoke-direct/range {v0 .. v7}, Lme;-><init>([BIIIIII)V

    goto :goto_0

    .line 355
    :cond_0
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unsupported picture format: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v3, 0x2f

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 334
    :pswitch_data_0
    .packed-switch 0x10
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method public b()V
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lmj;->f:Landroid/hardware/Camera;

    if-eqz v0, :cond_0

    .line 133
    invoke-static {}, Lmk;->a()V

    .line 134
    iget-object v0, p0, Lmj;->f:Landroid/hardware/Camera;

    invoke-virtual {v0}, Landroid/hardware/Camera;->release()V

    .line 135
    const/4 v0, 0x0

    iput-object v0, p0, Lmj;->f:Landroid/hardware/Camera;

    .line 137
    :cond_0
    return-void
.end method

.method public b(Landroid/os/Handler;I)V
    .locals 2

    .prologue
    .line 220
    iget-object v0, p0, Lmj;->f:Landroid/hardware/Camera;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lmj;->j:Z

    if-eqz v0, :cond_0

    .line 221
    iget-object v0, p0, Lmj;->m:Lmh;

    invoke-virtual {v0, p1, p2}, Lmh;->a(Landroid/os/Handler;I)V

    .line 223
    iget-object v0, p0, Lmj;->f:Landroid/hardware/Camera;

    iget-object v1, p0, Lmj;->m:Lmh;

    invoke-virtual {v0, v1}, Landroid/hardware/Camera;->autoFocus(Landroid/hardware/Camera$AutoFocusCallback;)V

    .line 225
    :cond_0
    return-void
.end method

.method public c()Z
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 140
    iget-object v1, p0, Lmj;->f:Landroid/hardware/Camera;

    invoke-virtual {v1}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v1

    .line 141
    invoke-virtual {v1}, Landroid/hardware/Camera$Parameters;->getSupportedFlashModes()Ljava/util/List;

    move-result-object v2

    .line 142
    if-eqz v2, :cond_0

    const-string v3, "torch"

    invoke-interface {v2, v3}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 143
    const-string v0, "torch"

    invoke-virtual {v1, v0}, Landroid/hardware/Camera$Parameters;->setFlashMode(Ljava/lang/String;)V

    .line 144
    iget-object v0, p0, Lmj;->f:Landroid/hardware/Camera;

    invoke-virtual {v0, v1}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V

    .line 145
    iget-object v0, p0, Lmj;->f:Landroid/hardware/Camera;

    invoke-virtual {v0}, Landroid/hardware/Camera;->startPreview()V

    .line 146
    const/4 v0, 0x1

    .line 149
    :goto_0
    return v0

    .line 148
    :cond_0
    iget-object v1, p0, Lmj;->d:Landroid/content/Context;

    const-string v2, "Flash not supported in this device."

    invoke-static {v1, v2, v0}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    goto :goto_0
.end method

.method public d()V
    .locals 2

    .prologue
    .line 155
    iget-object v0, p0, Lmj;->f:Landroid/hardware/Camera;

    invoke-virtual {v0}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v0

    .line 156
    const-string v1, "off"

    invoke-virtual {v0, v1}, Landroid/hardware/Camera$Parameters;->setFlashMode(Ljava/lang/String;)V

    .line 157
    iget-object v1, p0, Lmj;->f:Landroid/hardware/Camera;

    invoke-virtual {v1, v0}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V

    .line 158
    iget-object v0, p0, Lmj;->f:Landroid/hardware/Camera;

    invoke-virtual {v0}, Landroid/hardware/Camera;->startPreview()V

    .line 159
    return-void
.end method

.method public e()V
    .locals 1

    .prologue
    .line 166
    iget-object v0, p0, Lmj;->f:Landroid/hardware/Camera;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lmj;->j:Z

    if-nez v0, :cond_0

    .line 167
    iget-object v0, p0, Lmj;->f:Landroid/hardware/Camera;

    invoke-virtual {v0}, Landroid/hardware/Camera;->startPreview()V

    .line 168
    const/4 v0, 0x1

    iput-boolean v0, p0, Lmj;->j:Z

    .line 170
    :cond_0
    return-void
.end method

.method public f()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 177
    iget-object v0, p0, Lmj;->f:Landroid/hardware/Camera;

    if-eqz v0, :cond_1

    iget-boolean v0, p0, Lmj;->j:Z

    if-eqz v0, :cond_1

    .line 178
    iget-boolean v0, p0, Lmj;->k:Z

    if-nez v0, :cond_0

    .line 179
    iget-object v0, p0, Lmj;->f:Landroid/hardware/Camera;

    invoke-virtual {v0, v2}, Landroid/hardware/Camera;->setPreviewCallback(Landroid/hardware/Camera$PreviewCallback;)V

    .line 181
    :cond_0
    iget-object v0, p0, Lmj;->f:Landroid/hardware/Camera;

    invoke-virtual {v0}, Landroid/hardware/Camera;->stopPreview()V

    .line 182
    iget-object v0, p0, Lmj;->l:Lml;

    invoke-virtual {v0, v2, v1}, Lml;->a(Landroid/os/Handler;I)V

    .line 183
    iget-object v0, p0, Lmj;->m:Lmh;

    invoke-virtual {v0, v2, v1}, Lmh;->a(Landroid/os/Handler;I)V

    .line 184
    iput-boolean v1, p0, Lmj;->j:Z

    .line 186
    :cond_1
    return-void
.end method

.method public g()Landroid/graphics/Rect;
    .locals 5

    .prologue
    const/16 v0, 0x320

    const/16 v3, 0x2bc

    const/16 v1, 0xf0

    .line 237
    iget-object v2, p0, Lmj;->e:Lmi;

    invoke-virtual {v2}, Lmi;->b()Landroid/graphics/Point;

    move-result-object v4

    .line 238
    iget-object v2, p0, Lmj;->g:Landroid/graphics/Rect;

    if-nez v2, :cond_2

    .line 239
    iget-object v2, p0, Lmj;->f:Landroid/hardware/Camera;

    if-nez v2, :cond_0

    .line 240
    const/4 v0, 0x0

    .line 260
    :goto_0
    return-object v0

    .line 242
    :cond_0
    iget v2, v4, Landroid/graphics/Point;->x:I

    mul-int/lit8 v2, v2, 0x3

    div-int/lit8 v2, v2, 0x4

    .line 243
    if-ge v2, v1, :cond_3

    move v0, v1

    .line 248
    :cond_1
    :goto_1
    iget v2, v4, Landroid/graphics/Point;->y:I

    mul-int/lit8 v2, v2, 0x3

    div-int/lit8 v2, v2, 0x4

    .line 249
    if-ge v2, v1, :cond_4

    .line 254
    :goto_2
    iget v2, v4, Landroid/graphics/Point;->x:I

    sub-int/2addr v2, v0

    div-int/lit8 v2, v2, 0x2

    .line 255
    iget v3, v4, Landroid/graphics/Point;->y:I

    sub-int/2addr v3, v1

    div-int/lit8 v3, v3, 0x2

    .line 256
    new-instance v4, Landroid/graphics/Rect;

    add-int/2addr v0, v2

    add-int/2addr v1, v3

    invoke-direct {v4, v2, v3, v0, v1}, Landroid/graphics/Rect;-><init>(IIII)V

    iput-object v4, p0, Lmj;->g:Landroid/graphics/Rect;

    .line 260
    :cond_2
    iget-object v0, p0, Lmj;->g:Landroid/graphics/Rect;

    goto :goto_0

    .line 245
    :cond_3
    if-gt v2, v0, :cond_1

    move v0, v2

    goto :goto_1

    .line 251
    :cond_4
    if-le v2, v3, :cond_5

    move v1, v3

    .line 252
    goto :goto_2

    :cond_5
    move v1, v2

    goto :goto_2
.end method

.method public h()Landroid/graphics/Rect;
    .locals 5

    .prologue
    .line 269
    iget-object v0, p0, Lmj;->h:Landroid/graphics/Rect;

    if-nez v0, :cond_0

    .line 270
    new-instance v0, Landroid/graphics/Rect;

    invoke-virtual {p0}, Lmj;->g()Landroid/graphics/Rect;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/graphics/Rect;-><init>(Landroid/graphics/Rect;)V

    .line 271
    iget-object v1, p0, Lmj;->e:Lmi;

    invoke-virtual {v1}, Lmi;->a()Landroid/graphics/Point;

    move-result-object v1

    .line 272
    iget-object v2, p0, Lmj;->e:Lmi;

    invoke-virtual {v2}, Lmi;->b()Landroid/graphics/Point;

    move-result-object v2

    .line 273
    iget v3, v0, Landroid/graphics/Rect;->left:I

    iget v4, v1, Landroid/graphics/Point;->x:I

    mul-int/2addr v3, v4

    iget v4, v2, Landroid/graphics/Point;->x:I

    div-int/2addr v3, v4

    iput v3, v0, Landroid/graphics/Rect;->left:I

    .line 274
    iget v3, v0, Landroid/graphics/Rect;->right:I

    iget v4, v1, Landroid/graphics/Point;->x:I

    mul-int/2addr v3, v4

    iget v4, v2, Landroid/graphics/Point;->x:I

    div-int/2addr v3, v4

    iput v3, v0, Landroid/graphics/Rect;->right:I

    .line 275
    iget v3, v0, Landroid/graphics/Rect;->top:I

    iget v4, v1, Landroid/graphics/Point;->y:I

    mul-int/2addr v3, v4

    iget v4, v2, Landroid/graphics/Point;->y:I

    div-int/2addr v3, v4

    iput v3, v0, Landroid/graphics/Rect;->top:I

    .line 276
    iget v3, v0, Landroid/graphics/Rect;->bottom:I

    iget v1, v1, Landroid/graphics/Point;->y:I

    mul-int/2addr v1, v3

    iget v2, v2, Landroid/graphics/Point;->y:I

    div-int/2addr v1, v2

    iput v1, v0, Landroid/graphics/Rect;->bottom:I

    .line 277
    iput-object v0, p0, Lmj;->h:Landroid/graphics/Rect;

    .line 279
    :cond_0
    iget-object v0, p0, Lmj;->h:Landroid/graphics/Rect;

    return-object v0
.end method
