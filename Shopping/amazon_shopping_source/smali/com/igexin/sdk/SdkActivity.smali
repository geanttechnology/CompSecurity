.class public Lcom/igexin/sdk/SdkActivity;
.super Landroid/app/Activity;
.source "SdkActivity.java"


# instance fields
.field private action:Ljava/lang/String;

.field private dialog:Landroid/app/Dialog;

.field private flag:Z

.field private messageId:Ljava/lang/String;

.field private popupBean:Lcom/igexin/sdk/bean/PopupBean;

.field private pushMessageBean:Lcom/igexin/sdk/bean/PushMessageBean;

.field private screenHeight:I

.field private screenWidth:I

.field private taskId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 29
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 37
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/igexin/sdk/SdkActivity;->flag:Z

    return-void
.end method

.method static synthetic access$000(Lcom/igexin/sdk/SdkActivity;)Lcom/igexin/sdk/bean/PushMessageBean;
    .locals 1
    .param p0, "x0"    # Lcom/igexin/sdk/SdkActivity;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/igexin/sdk/SdkActivity;->pushMessageBean:Lcom/igexin/sdk/bean/PushMessageBean;

    return-object v0
.end method

.method static synthetic access$102(Lcom/igexin/sdk/SdkActivity;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/igexin/sdk/SdkActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 29
    iput-boolean p1, p0, Lcom/igexin/sdk/SdkActivity;->flag:Z

    return p1
.end method

.method private doStopAction()V
    .locals 3

    .prologue
    .line 252
    iget-object v1, p0, Lcom/igexin/sdk/SdkActivity;->popupBean:Lcom/igexin/sdk/bean/PopupBean;

    if-eqz v1, :cond_0

    .line 253
    iget-object v1, p0, Lcom/igexin/sdk/SdkActivity;->popupBean:Lcom/igexin/sdk/bean/PopupBean;

    invoke-virtual {v1}, Lcom/igexin/sdk/bean/PopupBean;->getDoActionId()Ljava/lang/String;

    move-result-object v0

    .line 254
    .local v0, "doActionId":Ljava/lang/String;
    const-string/jumbo v1, ""

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 255
    invoke-static {}, Lcom/igexin/sdk/action/PushMessageAction;->getInstance()Lcom/igexin/sdk/action/PushMessageAction;

    move-result-object v1

    iget-object v2, p0, Lcom/igexin/sdk/SdkActivity;->pushMessageBean:Lcom/igexin/sdk/bean/PushMessageBean;

    invoke-virtual {v1, v2, v0}, Lcom/igexin/sdk/action/PushMessageAction;->executePushMessageAction(Lcom/igexin/sdk/bean/PushMessageBean;Ljava/lang/String;)Z

    .line 257
    .end local v0    # "doActionId":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method private getButtonText(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 243
    move-object v0, p1

    .line 245
    .local v0, "result":Ljava/lang/String;
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    const/16 v2, 0x14

    if-le v1, v2, :cond_0

    .line 246
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v2, 0x0

    const/16 v3, 0x12

    invoke-virtual {p1, v2, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "..."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 248
    :cond_0
    return-object v0
.end method

.method private getText(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 233
    move-object v0, p1

    .line 235
    .local v0, "result":Ljava/lang/String;
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    const/16 v2, 0x100

    if-le v1, v2, :cond_0

    .line 236
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v2, 0x0

    const/16 v3, 0xfe

    invoke-virtual {p1, v2, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "..."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 238
    :cond_0
    return-object v0
.end method

.method private showDialog()V
    .locals 34

    .prologue
    .line 107
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/igexin/sdk/SdkActivity;->popupBean:Lcom/igexin/sdk/bean/PopupBean;

    invoke-virtual {v3}, Lcom/igexin/sdk/bean/PopupBean;->getTitle()Ljava/lang/String;

    move-result-object v32

    .line 108
    .local v32, "title":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/igexin/sdk/SdkActivity;->popupBean:Lcom/igexin/sdk/bean/PopupBean;

    invoke-virtual {v3}, Lcom/igexin/sdk/bean/PopupBean;->getContent()Ljava/lang/String;

    move-result-object v18

    .line 109
    .local v18, "message":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/igexin/sdk/SdkActivity;->popupBean:Lcom/igexin/sdk/bean/PopupBean;

    invoke-virtual {v3}, Lcom/igexin/sdk/bean/PopupBean;->getImg_src()Ljava/lang/String;

    move-result-object v15

    .line 111
    .local v15, "img_src":Ljava/lang/String;
    new-instance v3, Landroid/app/AlertDialog$Builder;

    move-object/from16 v0, p0

    invoke-direct {v3, v0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    move-object/from16 v0, v32

    invoke-virtual {v3, v0}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v3

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-direct {v0, v1}, Lcom/igexin/sdk/SdkActivity;->getText(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v10

    .line 113
    .local v10, "builder":Landroid/app/AlertDialog$Builder;
    if-eqz v15, :cond_2

    .line 114
    new-instance v14, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    invoke-direct {v14, v0}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 115
    .local v14, "imgView":Landroid/widget/ImageView;
    const/4 v2, 0x0

    .line 117
    .local v2, "bmp":Landroid/graphics/Bitmap;
    const/16 v16, 0x0

    .line 119
    .local v16, "localStream":Ljava/io/FileInputStream;
    :try_start_0
    new-instance v17, Ljava/io/FileInputStream;

    move-object/from16 v0, v17

    invoke-direct {v0, v15}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .end local v16    # "localStream":Ljava/io/FileInputStream;
    .local v17, "localStream":Ljava/io/FileInputStream;
    move-object/from16 v16, v17

    .line 126
    .end local v17    # "localStream":Ljava/io/FileInputStream;
    .restart local v16    # "localStream":Ljava/io/FileInputStream;
    :goto_0
    if-eqz v16, :cond_0

    .line 127
    invoke-static/range {v16 .. v16}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;)Landroid/graphics/Bitmap;

    move-result-object v2

    .line 129
    :cond_0
    if-eqz v2, :cond_2

    .line 132
    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v33

    .line 133
    .local v33, "w":I
    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v13

    .line 134
    .local v13, "h":I
    const/16 v19, 0x0

    .line 135
    .local v19, "size":F
    move-object/from16 v0, p0

    iget v3, v0, Lcom/igexin/sdk/SdkActivity;->screenHeight:I

    int-to-double v3, v3

    const-wide/high16 v5, 0x4089000000000000L    # 800.0

    div-double v20, v3, v5

    .line 136
    .local v20, "sizeH":D
    const-wide v3, 0x4075e00000000000L    # 350.0

    mul-double v24, v3, v20

    .line 137
    .local v24, "sizeimgH":D
    int-to-double v3, v13

    div-double v26, v24, v3

    .line 138
    .local v26, "sizeimgHp":D
    move-object/from16 v0, p0

    iget v3, v0, Lcom/igexin/sdk/SdkActivity;->screenWidth:I

    int-to-double v3, v3

    const-wide/high16 v5, 0x407e000000000000L    # 480.0

    div-double v22, v3, v5

    .line 139
    .local v22, "sizeW":D
    const-wide v3, 0x4075e00000000000L    # 350.0

    mul-double v28, v3, v22

    .line 140
    .local v28, "sizeimgW":D
    move/from16 v0, v33

    int-to-double v3, v0

    div-double v30, v28, v3

    .line 141
    .local v30, "sizeimgWp":D
    const-wide/high16 v3, 0x3ff0000000000000L    # 1.0

    cmpl-double v3, v26, v3

    if-ltz v3, :cond_6

    const-wide/high16 v3, 0x3ff0000000000000L    # 1.0

    cmpl-double v3, v30, v3

    if-ltz v3, :cond_6

    .line 142
    const/high16 v19, 0x3f800000    # 1.0f

    .line 153
    :cond_1
    :goto_1
    new-instance v7, Landroid/graphics/Matrix;

    invoke-direct {v7}, Landroid/graphics/Matrix;-><init>()V

    .line 154
    .local v7, "matrix":Landroid/graphics/Matrix;
    move/from16 v0, v19

    move/from16 v1, v19

    invoke-virtual {v7, v0, v1}, Landroid/graphics/Matrix;->postScale(FF)Z

    .line 156
    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v5

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v6

    const/4 v8, 0x1

    invoke-static/range {v2 .. v8}, Landroid/graphics/Bitmap;->createBitmap(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;

    move-result-object v9

    .line 157
    .local v9, "bm":Landroid/graphics/Bitmap;
    invoke-virtual {v14, v9}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 158
    const/4 v3, 0x0

    invoke-virtual {v14, v3}, Landroid/widget/ImageView;->setMaxHeight(I)V

    .line 159
    const/4 v3, 0x0

    invoke-virtual {v14, v3}, Landroid/widget/ImageView;->setMinimumHeight(I)V

    .line 160
    invoke-virtual {v10, v14}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 164
    .end local v2    # "bmp":Landroid/graphics/Bitmap;
    .end local v7    # "matrix":Landroid/graphics/Matrix;
    .end local v9    # "bm":Landroid/graphics/Bitmap;
    .end local v13    # "h":I
    .end local v14    # "imgView":Landroid/widget/ImageView;
    .end local v16    # "localStream":Ljava/io/FileInputStream;
    .end local v19    # "size":F
    .end local v20    # "sizeH":D
    .end local v22    # "sizeW":D
    .end local v24    # "sizeimgH":D
    .end local v26    # "sizeimgHp":D
    .end local v28    # "sizeimgW":D
    .end local v30    # "sizeimgWp":D
    .end local v33    # "w":I
    :cond_2
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/igexin/sdk/SdkActivity;->popupBean:Lcom/igexin/sdk/bean/PopupBean;

    invoke-virtual {v3}, Lcom/igexin/sdk/bean/PopupBean;->getButtons()Ljava/util/List;

    move-result-object v3

    if-eqz v3, :cond_5

    .line 166
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/igexin/sdk/SdkActivity;->popupBean:Lcom/igexin/sdk/bean/PopupBean;

    invoke-virtual {v3}, Lcom/igexin/sdk/bean/PopupBean;->getButtons()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    const/4 v4, 0x1

    if-lt v3, v4, :cond_3

    .line 167
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/igexin/sdk/SdkActivity;->popupBean:Lcom/igexin/sdk/bean/PopupBean;

    invoke-virtual {v3}, Lcom/igexin/sdk/bean/PopupBean;->getButtons()Ljava/util/List;

    move-result-object v3

    const/4 v4, 0x0

    invoke-interface {v3, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Lcom/igexin/sdk/bean/ButtonBean;

    .line 168
    .local v11, "button":Lcom/igexin/sdk/bean/ButtonBean;
    invoke-virtual {v11}, Lcom/igexin/sdk/bean/ButtonBean;->getText()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Lcom/igexin/sdk/SdkActivity;->getButtonText(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lcom/igexin/sdk/SdkActivity$1;

    move-object/from16 v0, p0

    invoke-direct {v4, v0, v11}, Lcom/igexin/sdk/SdkActivity$1;-><init>(Lcom/igexin/sdk/SdkActivity;Lcom/igexin/sdk/bean/ButtonBean;)V

    invoke-virtual {v10, v3, v4}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 178
    .end local v11    # "button":Lcom/igexin/sdk/bean/ButtonBean;
    :cond_3
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/igexin/sdk/SdkActivity;->popupBean:Lcom/igexin/sdk/bean/PopupBean;

    invoke-virtual {v3}, Lcom/igexin/sdk/bean/PopupBean;->getButtons()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    const/4 v4, 0x2

    if-lt v3, v4, :cond_4

    .line 179
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/igexin/sdk/SdkActivity;->popupBean:Lcom/igexin/sdk/bean/PopupBean;

    invoke-virtual {v3}, Lcom/igexin/sdk/bean/PopupBean;->getButtons()Ljava/util/List;

    move-result-object v3

    const/4 v4, 0x1

    invoke-interface {v3, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Lcom/igexin/sdk/bean/ButtonBean;

    .line 180
    .restart local v11    # "button":Lcom/igexin/sdk/bean/ButtonBean;
    invoke-virtual {v11}, Lcom/igexin/sdk/bean/ButtonBean;->getText()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Lcom/igexin/sdk/SdkActivity;->getButtonText(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lcom/igexin/sdk/SdkActivity$2;

    move-object/from16 v0, p0

    invoke-direct {v4, v0, v11}, Lcom/igexin/sdk/SdkActivity$2;-><init>(Lcom/igexin/sdk/SdkActivity;Lcom/igexin/sdk/bean/ButtonBean;)V

    invoke-virtual {v10, v3, v4}, Landroid/app/AlertDialog$Builder;->setNeutralButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 190
    .end local v11    # "button":Lcom/igexin/sdk/bean/ButtonBean;
    :cond_4
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/igexin/sdk/SdkActivity;->popupBean:Lcom/igexin/sdk/bean/PopupBean;

    invoke-virtual {v3}, Lcom/igexin/sdk/bean/PopupBean;->getButtons()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    const/4 v4, 0x3

    if-lt v3, v4, :cond_5

    .line 191
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/igexin/sdk/SdkActivity;->popupBean:Lcom/igexin/sdk/bean/PopupBean;

    invoke-virtual {v3}, Lcom/igexin/sdk/bean/PopupBean;->getButtons()Ljava/util/List;

    move-result-object v3

    const/4 v4, 0x2

    invoke-interface {v3, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Lcom/igexin/sdk/bean/ButtonBean;

    .line 192
    .restart local v11    # "button":Lcom/igexin/sdk/bean/ButtonBean;
    invoke-virtual {v11}, Lcom/igexin/sdk/bean/ButtonBean;->getText()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Lcom/igexin/sdk/SdkActivity;->getButtonText(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lcom/igexin/sdk/SdkActivity$3;

    move-object/from16 v0, p0

    invoke-direct {v4, v0, v11}, Lcom/igexin/sdk/SdkActivity$3;-><init>(Lcom/igexin/sdk/SdkActivity;Lcom/igexin/sdk/bean/ButtonBean;)V

    invoke-virtual {v10, v3, v4}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 203
    .end local v11    # "button":Lcom/igexin/sdk/bean/ButtonBean;
    :cond_5
    invoke-virtual {v10}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/igexin/sdk/SdkActivity;->dialog:Landroid/app/Dialog;

    .line 204
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/igexin/sdk/SdkActivity;->dialog:Landroid/app/Dialog;

    invoke-virtual {v3}, Landroid/app/Dialog;->show()V

    .line 205
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/igexin/sdk/SdkActivity;->dialog:Landroid/app/Dialog;

    new-instance v4, Lcom/igexin/sdk/SdkActivity$4;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Lcom/igexin/sdk/SdkActivity$4;-><init>(Lcom/igexin/sdk/SdkActivity;)V

    invoke-virtual {v3, v4}, Landroid/app/Dialog;->setOnKeyListener(Landroid/content/DialogInterface$OnKeyListener;)V

    .line 219
    return-void

    .line 120
    .restart local v2    # "bmp":Landroid/graphics/Bitmap;
    .restart local v14    # "imgView":Landroid/widget/ImageView;
    .restart local v16    # "localStream":Ljava/io/FileInputStream;
    :catch_0
    move-exception v12

    .line 123
    .local v12, "e":Ljava/io/FileNotFoundException;
    invoke-virtual {v12}, Ljava/io/FileNotFoundException;->printStackTrace()V

    goto/16 :goto_0

    .line 143
    .end local v12    # "e":Ljava/io/FileNotFoundException;
    .restart local v13    # "h":I
    .restart local v19    # "size":F
    .restart local v20    # "sizeH":D
    .restart local v22    # "sizeW":D
    .restart local v24    # "sizeimgH":D
    .restart local v26    # "sizeimgHp":D
    .restart local v28    # "sizeimgW":D
    .restart local v30    # "sizeimgWp":D
    .restart local v33    # "w":I
    :cond_6
    const-wide/high16 v3, 0x3ff0000000000000L    # 1.0

    cmpl-double v3, v26, v3

    if-ltz v3, :cond_7

    const-wide/high16 v3, 0x3ff0000000000000L    # 1.0

    cmpg-double v3, v30, v3

    if-gez v3, :cond_7

    .line 144
    move-wide/from16 v0, v30

    double-to-float v0, v0

    move/from16 v19, v0

    goto/16 :goto_1

    .line 145
    :cond_7
    const-wide/high16 v3, 0x3ff0000000000000L    # 1.0

    cmpg-double v3, v26, v3

    if-gez v3, :cond_8

    const-wide/high16 v3, 0x3ff0000000000000L    # 1.0

    cmpl-double v3, v30, v3

    if-ltz v3, :cond_8

    .line 146
    move-wide/from16 v0, v26

    double-to-float v0, v0

    move/from16 v19, v0

    goto/16 :goto_1

    .line 147
    :cond_8
    const-wide/high16 v3, 0x3ff0000000000000L    # 1.0

    cmpg-double v3, v26, v3

    if-gez v3, :cond_1

    const-wide/high16 v3, 0x3ff0000000000000L    # 1.0

    cmpg-double v3, v30, v3

    if-gez v3, :cond_1

    .line 148
    cmpl-double v3, v26, v30

    if-lez v3, :cond_9

    .line 149
    move-wide/from16 v0, v30

    double-to-float v0, v0

    move/from16 v19, v0

    goto/16 :goto_1

    .line 151
    :cond_9
    move-wide/from16 v0, v26

    double-to-float v0, v0

    move/from16 v19, v0

    goto/16 :goto_1
.end method


# virtual methods
.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 2
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 71
    invoke-super {p0, p1}, Landroid/app/Activity;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 72
    invoke-virtual {p0}, Lcom/igexin/sdk/SdkActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    .line 73
    .local v0, "dm":Landroid/util/DisplayMetrics;
    iget v1, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    iput v1, p0, Lcom/igexin/sdk/SdkActivity;->screenHeight:I

    .line 74
    iget v1, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    iput v1, p0, Lcom/igexin/sdk/SdkActivity;->screenWidth:I

    .line 75
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v3, 0x3

    .line 60
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 61
    invoke-virtual {p0, v3}, Lcom/igexin/sdk/SdkActivity;->requestWindowFeature(I)Z

    .line 62
    invoke-virtual {p0}, Lcom/igexin/sdk/SdkActivity;->getWindow()Landroid/view/Window;

    move-result-object v1

    const v2, 0x108009b

    invoke-virtual {v1, v3, v2}, Landroid/view/Window;->setFeatureDrawableResource(II)V

    .line 63
    invoke-virtual {p0}, Lcom/igexin/sdk/SdkActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    .line 64
    .local v0, "dm":Landroid/util/DisplayMetrics;
    iget v1, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    iput v1, p0, Lcom/igexin/sdk/SdkActivity;->screenHeight:I

    .line 65
    iget v1, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    iput v1, p0, Lcom/igexin/sdk/SdkActivity;->screenWidth:I

    .line 66
    const/4 v1, 0x2

    invoke-virtual {p0, v1}, Lcom/igexin/sdk/SdkActivity;->setRequestedOrientation(I)V

    .line 67
    return-void
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/igexin/sdk/SdkActivity;->dialog:Landroid/app/Dialog;

    if-eqz v0, :cond_0

    .line 53
    iget-object v0, p0, Lcom/igexin/sdk/SdkActivity;->dialog:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->dismiss()V

    .line 55
    :cond_0
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 56
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 223
    const/4 v0, 0x4

    if-ne p1, v0, :cond_0

    .line 224
    invoke-direct {p0}, Lcom/igexin/sdk/SdkActivity;->doStopAction()V

    .line 225
    const/4 v0, 0x1

    .line 228
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/igexin/sdk/SdkActivity;->flag:Z

    if-eqz v0, :cond_0

    .line 46
    invoke-direct {p0}, Lcom/igexin/sdk/SdkActivity;->doStopAction()V

    .line 47
    :cond_0
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 48
    return-void
.end method

.method protected onStart()V
    .locals 5

    .prologue
    .line 79
    invoke-super {p0}, Landroid/app/Activity;->onStart()V

    .line 81
    invoke-virtual {p0}, Lcom/igexin/sdk/SdkActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 82
    .local v1, "intent":Landroid/content/Intent;
    if-nez v1, :cond_0

    .line 83
    invoke-virtual {p0}, Lcom/igexin/sdk/SdkActivity;->finish()V

    .line 103
    :goto_0
    return-void

    .line 86
    :cond_0
    const-string/jumbo v2, "action"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/igexin/sdk/SdkActivity;->action:Ljava/lang/String;

    .line 88
    const-string/jumbo v2, "popup"

    iget-object v3, p0, Lcom/igexin/sdk/SdkActivity;->action:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 90
    const-string/jumbo v2, "messageId"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/igexin/sdk/SdkActivity;->messageId:Ljava/lang/String;

    .line 91
    const-string/jumbo v2, "taskId"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/igexin/sdk/SdkActivity;->taskId:Ljava/lang/String;

    .line 93
    invoke-static {}, Lcom/igexin/sdk/action/PushMessageAction;->getInstance()Lcom/igexin/sdk/action/PushMessageAction;

    move-result-object v2

    iget-object v3, p0, Lcom/igexin/sdk/SdkActivity;->taskId:Ljava/lang/String;

    iget-object v4, p0, Lcom/igexin/sdk/SdkActivity;->messageId:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/igexin/sdk/action/PushMessageAction;->getPushMessageCacheId(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 94
    .local v0, "cacheId":Ljava/lang/String;
    sget-object v2, Lcom/igexin/sdk/data/BasicDataManager;->pushMessageMap:Ljava/util/Map;

    invoke-interface {v2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/igexin/sdk/bean/PushMessageBean;

    iput-object v2, p0, Lcom/igexin/sdk/SdkActivity;->pushMessageBean:Lcom/igexin/sdk/bean/PushMessageBean;

    .line 95
    iget-object v2, p0, Lcom/igexin/sdk/SdkActivity;->pushMessageBean:Lcom/igexin/sdk/bean/PushMessageBean;

    iget-object v3, p0, Lcom/igexin/sdk/SdkActivity;->pushMessageBean:Lcom/igexin/sdk/bean/PushMessageBean;

    invoke-virtual {v3}, Lcom/igexin/sdk/bean/PushMessageBean;->getActionId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/igexin/sdk/bean/PushMessageBean;->getBean(Ljava/lang/String;)Lcom/igexin/sdk/bean/BaseBean;

    move-result-object v2

    check-cast v2, Lcom/igexin/sdk/bean/PopupBean;

    iput-object v2, p0, Lcom/igexin/sdk/SdkActivity;->popupBean:Lcom/igexin/sdk/bean/PopupBean;

    .line 97
    invoke-direct {p0}, Lcom/igexin/sdk/SdkActivity;->showDialog()V

    goto :goto_0

    .line 100
    .end local v0    # "cacheId":Ljava/lang/String;
    :cond_1
    invoke-virtual {p0}, Lcom/igexin/sdk/SdkActivity;->finish()V

    goto :goto_0
.end method
