.class synthetic Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$6;
.super Ljava/lang/Object;
.source "HetroFeedListAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1008
    name = null
.end annotation


# static fields
.field static final synthetic $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout:[I

.field static final synthetic $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemFooterLayout$Layout:[I

.field static final synthetic $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemHeaderLayout$Layout:[I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 286
    invoke-static {}, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;->values()[Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$6;->$SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemFooterLayout$Layout:[I

    :try_start_0
    sget-object v0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$6;->$SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemFooterLayout$Layout:[I

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;->SIMPLE_LAUNCH_FOOTER:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_b

    :goto_0
    :try_start_1
    sget-object v0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$6;->$SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemFooterLayout$Layout:[I

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;->SOCIAL_ACTIONS_FOOTER:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_a

    :goto_1
    :try_start_2
    sget-object v0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$6;->$SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemFooterLayout$Layout:[I

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;->LEGACY_FOOTER:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_9

    .line 255
    :goto_2
    invoke-static {}, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->values()[Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$6;->$SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout:[I

    :try_start_3
    sget-object v0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$6;->$SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout:[I

    sget-object v1, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->SIFU_SOCIAL:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_3
    .catch Ljava/lang/NoSuchFieldError; {:try_start_3 .. :try_end_3} :catch_8

    :goto_3
    :try_start_4
    sget-object v0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$6;->$SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout:[I

    sget-object v1, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->MIFU_3_FLUID_LARGE_LEFT:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_4
    .catch Ljava/lang/NoSuchFieldError; {:try_start_4 .. :try_end_4} :catch_7

    :goto_4
    :try_start_5
    sget-object v0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$6;->$SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout:[I

    sget-object v1, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->MIFU_4_GRID:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_5
    .catch Ljava/lang/NoSuchFieldError; {:try_start_5 .. :try_end_5} :catch_6

    :goto_5
    :try_start_6
    sget-object v0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$6;->$SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout:[I

    sget-object v1, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->SIFU_SUMMARY:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1
    :try_end_6
    .catch Ljava/lang/NoSuchFieldError; {:try_start_6 .. :try_end_6} :catch_5

    :goto_6
    :try_start_7
    sget-object v0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$6;->$SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout:[I

    sget-object v1, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->SIFU_LEFT_IMAGE_RIGHT_TEXT:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->ordinal()I

    move-result v1

    const/4 v2, 0x5

    aput v2, v0, v1
    :try_end_7
    .catch Ljava/lang/NoSuchFieldError; {:try_start_7 .. :try_end_7} :catch_4

    .line 229
    :goto_7
    invoke-static {}, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->values()[Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$6;->$SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemHeaderLayout$Layout:[I

    :try_start_8
    sget-object v0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$6;->$SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemHeaderLayout$Layout:[I

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->SINGLE_LEVEL_HEADER:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_8
    .catch Ljava/lang/NoSuchFieldError; {:try_start_8 .. :try_end_8} :catch_3

    :goto_8
    :try_start_9
    sget-object v0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$6;->$SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemHeaderLayout$Layout:[I

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->DOUBLE_LEVEL_HEADER:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_9
    .catch Ljava/lang/NoSuchFieldError; {:try_start_9 .. :try_end_9} :catch_2

    :goto_9
    :try_start_a
    sget-object v0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$6;->$SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemHeaderLayout$Layout:[I

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->LEGACY_HEADER:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_a
    .catch Ljava/lang/NoSuchFieldError; {:try_start_a .. :try_end_a} :catch_1

    :goto_a
    :try_start_b
    sget-object v0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$6;->$SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemHeaderLayout$Layout:[I

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->SINGLE_LEVEL_HEADER_POSHPOST:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1
    :try_end_b
    .catch Ljava/lang/NoSuchFieldError; {:try_start_b .. :try_end_b} :catch_0

    :goto_b
    return-void

    :catch_0
    move-exception v0

    goto :goto_b

    :catch_1
    move-exception v0

    goto :goto_a

    :catch_2
    move-exception v0

    goto :goto_9

    :catch_3
    move-exception v0

    goto :goto_8

    .line 255
    :catch_4
    move-exception v0

    goto :goto_7

    :catch_5
    move-exception v0

    goto :goto_6

    :catch_6
    move-exception v0

    goto :goto_5

    :catch_7
    move-exception v0

    goto :goto_4

    :catch_8
    move-exception v0

    goto :goto_3

    .line 286
    :catch_9
    move-exception v0

    goto/16 :goto_2

    :catch_a
    move-exception v0

    goto/16 :goto_1

    :catch_b
    move-exception v0

    goto/16 :goto_0
.end method
