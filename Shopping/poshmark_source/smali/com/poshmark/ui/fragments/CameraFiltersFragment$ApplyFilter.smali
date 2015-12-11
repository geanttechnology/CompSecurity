.class Lcom/poshmark/ui/fragments/CameraFiltersFragment$ApplyFilter;
.super Landroid/os/AsyncTask;
.source "CameraFiltersFragment.java"

# interfaces
.implements Lcom/newrelic/agent/android/api/v2/TraceFieldInterface;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/CameraFiltersFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ApplyFilter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/Void;",
        "Landroid/graphics/drawable/Drawable;",
        ">;"
    }
.end annotation


# instance fields
.field public _nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

.field final synthetic this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;


# direct methods
.method private constructor <init>(Lcom/poshmark/ui/fragments/CameraFiltersFragment;)V
    .locals 0

    .prologue
    .line 243
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$ApplyFilter;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/poshmark/ui/fragments/CameraFiltersFragment;Lcom/poshmark/ui/fragments/CameraFiltersFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/poshmark/ui/fragments/CameraFiltersFragment;
    .param p2, "x1"    # Lcom/poshmark/ui/fragments/CameraFiltersFragment$1;

    .prologue
    .line 243
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$ApplyFilter;-><init>(Lcom/poshmark/ui/fragments/CameraFiltersFragment;)V

    return-void
.end method


# virtual methods
.method public _nr_setTrace(Lcom/newrelic/agent/android/tracing/Trace;)V
    .locals 1

    :try_start_0
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$ApplyFilter;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    .locals 9
    .param p1, "filterTypes"    # [Ljava/lang/String;

    .prologue
    .line 250
    const/4 v0, 0x0

    .line 251
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    const/4 v1, 0x0

    aget-object v1, p1, v1

    invoke-static {v1}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->valueOf(Ljava/lang/String;)Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    move-result-object v8

    .line 253
    .local v8, "type":Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;
    sget-object v1, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->FILTER_TYPE_MODERN:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    if-ne v8, v1, :cond_1

    .line 254
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$ApplyFilter;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    # invokes: Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getDisplayBitmap()Landroid/graphics/Bitmap;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->access$300(Lcom/poshmark/ui/fragments/CameraFiltersFragment;)Landroid/graphics/Bitmap;

    move-result-object v1

    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    const-wide/high16 v4, 0x3ff0000000000000L    # 1.0

    const-wide v6, 0x3ff6666666666666L    # 1.4

    invoke-static/range {v1 .. v7}, Lcom/poshmark/image_processing/ImageEffects;->balanceColor(Landroid/graphics/Bitmap;DDD)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 255
    const/high16 v1, 0x3f800000    # 1.0f

    const/high16 v2, 0x3f800000    # 1.0f

    const v3, 0x3f99999a    # 1.2f

    invoke-static {v0, v1, v2, v3}, Lcom/poshmark/image_processing/ImageEffects;->adjustImage(Landroid/graphics/Bitmap;FFF)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 256
    const-string v1, "overlay_vignette_border_black_thick"

    invoke-static {v0, v1}, Lcom/poshmark/image_processing/ImageEffects;->applyOverlay(Landroid/graphics/Bitmap;Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 276
    :cond_0
    :goto_0
    new-instance v1, Landroid/graphics/drawable/BitmapDrawable;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$ApplyFilter;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    return-object v1

    .line 257
    :cond_1
    sget-object v1, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->FILTER_TYPE_VINTAGE:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    if-ne v8, v1, :cond_2

    .line 258
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$ApplyFilter;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    # invokes: Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getDisplayBitmap()Landroid/graphics/Bitmap;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->access$300(Lcom/poshmark/ui/fragments/CameraFiltersFragment;)Landroid/graphics/Bitmap;

    move-result-object v1

    const/high16 v2, 0x3f800000    # 1.0f

    const/high16 v3, 0x3f800000    # 1.0f

    const v4, 0x3f99999a    # 1.2f

    invoke-static {v1, v2, v3, v4}, Lcom/poshmark/image_processing/ImageEffects;->adjustImage(Landroid/graphics/Bitmap;FFF)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 259
    const/16 v1, 0xff

    const/16 v2, 0xf7

    const/16 v3, 0xda

    const/16 v4, 0xae

    invoke-static {v1, v2, v3, v4}, Landroid/graphics/Color;->argb(IIII)I

    move-result v1

    sget-object v2, Landroid/graphics/PorterDuff$Mode;->MULTIPLY:Landroid/graphics/PorterDuff$Mode;

    invoke-static {v0, v1, v2}, Lcom/poshmark/image_processing/ImageEffects;->blendColor(Landroid/graphics/Bitmap;ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 260
    const-string v1, "overlay_vignette_warm_border_black_thick"

    invoke-static {v0, v1}, Lcom/poshmark/image_processing/ImageEffects;->applyOverlay(Landroid/graphics/Bitmap;Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    goto :goto_0

    .line 261
    :cond_2
    sget-object v1, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->FILTER_TYPE_RETRO:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    if-ne v8, v1, :cond_3

    .line 262
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$ApplyFilter;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    # invokes: Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getDisplayBitmap()Landroid/graphics/Bitmap;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->access$300(Lcom/poshmark/ui/fragments/CameraFiltersFragment;)Landroid/graphics/Bitmap;

    move-result-object v1

    const-wide v2, 0x3ff6666666666666L    # 1.4

    const-wide v4, 0x3ff4cccccccccccdL    # 1.3

    const-wide/high16 v6, 0x3ff0000000000000L    # 1.0

    invoke-static/range {v1 .. v7}, Lcom/poshmark/image_processing/ImageEffects;->balanceColor(Landroid/graphics/Bitmap;DDD)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 263
    const-string v1, "overlay_border_black_thick"

    invoke-static {v0, v1}, Lcom/poshmark/image_processing/ImageEffects;->applyOverlay(Landroid/graphics/Bitmap;Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    goto :goto_0

    .line 264
    :cond_3
    sget-object v1, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->FILTER_TYPE_CHIC:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    if-ne v8, v1, :cond_4

    .line 265
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$ApplyFilter;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    # invokes: Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getDisplayBitmap()Landroid/graphics/Bitmap;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->access$300(Lcom/poshmark/ui/fragments/CameraFiltersFragment;)Landroid/graphics/Bitmap;

    move-result-object v1

    const-wide v2, 0x3ff3333333333333L    # 1.2

    const-wide/high16 v4, 0x3ff0000000000000L    # 1.0

    const-wide v6, 0x3fe6666666666666L    # 0.7

    invoke-static/range {v1 .. v7}, Lcom/poshmark/image_processing/ImageEffects;->balanceColor(Landroid/graphics/Bitmap;DDD)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 266
    const v1, 0x3f99999a    # 1.2f

    const/high16 v2, 0x3f800000    # 1.0f

    const v3, 0x3f333333    # 0.7f

    invoke-static {v0, v1, v2, v3}, Lcom/poshmark/image_processing/ImageEffects;->adjustImage(Landroid/graphics/Bitmap;FFF)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 267
    const-string v1, "overlay_effect_lightleak"

    invoke-static {v0, v1}, Lcom/poshmark/image_processing/ImageEffects;->applyOverlay(Landroid/graphics/Bitmap;Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 268
    const-string v1, "overlay_border_black_thick"

    invoke-static {v0, v1}, Lcom/poshmark/image_processing/ImageEffects;->applyOverlay(Landroid/graphics/Bitmap;Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    goto/16 :goto_0

    .line 269
    :cond_4
    sget-object v1, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->FILTER_TYPE_STREET:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    if-ne v8, v1, :cond_5

    .line 270
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$ApplyFilter;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    # invokes: Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getDisplayBitmap()Landroid/graphics/Bitmap;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->access$300(Lcom/poshmark/ui/fragments/CameraFiltersFragment;)Landroid/graphics/Bitmap;

    move-result-object v1

    const/high16 v2, 0x3fc00000    # 1.5f

    const/high16 v3, 0x3f800000    # 1.0f

    const v4, 0x3fb33333    # 1.4f

    invoke-static {v1, v2, v3, v4}, Lcom/poshmark/image_processing/ImageEffects;->adjustImage(Landroid/graphics/Bitmap;FFF)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 271
    const-string v1, "overlay_border_white_thick"

    invoke-static {v0, v1}, Lcom/poshmark/image_processing/ImageEffects;->applyOverlay(Landroid/graphics/Bitmap;Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    goto/16 :goto_0

    .line 272
    :cond_5
    sget-object v1, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->FILTER_TYPE_CLASSIC:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    if-ne v8, v1, :cond_0

    .line 273
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$ApplyFilter;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    # invokes: Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getDisplayBitmap()Landroid/graphics/Bitmap;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->access$300(Lcom/poshmark/ui/fragments/CameraFiltersFragment;)Landroid/graphics/Bitmap;

    move-result-object v1

    invoke-static {v1}, Lcom/poshmark/image_processing/ImageEffects;->convertImageToGrayScale(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;

    move-result-object v0

    goto/16 :goto_0
.end method

.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3

    .prologue
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$ApplyFilter;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v1, "CameraFiltersFragment$ApplyFilter#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 243
    :goto_0
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$ApplyFilter;->doInBackground([Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    invoke-static {p0}, Lcom/newrelic/agent/android/tracing/TraceMachine;->unloadTraceContext(Ljava/lang/Object;)V

    return-object v0

    .line 4294967295
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "CameraFiltersFragment$ApplyFilter#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method protected onPostExecute(Landroid/graphics/drawable/Drawable;)V
    .locals 2
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 280
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$ApplyFilter;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    iput-object p1, v0, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->filteredDrawable:Landroid/graphics/drawable/Drawable;

    .line 281
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$ApplyFilter;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->imageView:Lcom/poshmark/ui/customviews/PMListingImageView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$ApplyFilter;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->filteredDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListingImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 282
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$ApplyFilter;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->hideProgressDialog()V

    .line 283
    return-void
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 3

    .prologue
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$ApplyFilter;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v1, "CameraFiltersFragment$ApplyFilter#onPostExecute"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 243
    :goto_0
    check-cast p1, Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0, p1}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$ApplyFilter;->onPostExecute(Landroid/graphics/drawable/Drawable;)V

    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    return-void

    .line 4294967295
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "CameraFiltersFragment$ApplyFilter#onPostExecute"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method protected onPreExecute()V
    .locals 3

    .prologue
    .line 246
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$ApplyFilter;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$ApplyFilter;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    const v2, 0x7f06009a

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 247
    return-void
.end method
