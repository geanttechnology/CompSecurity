.class Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1;
.super Landroid/widget/Filter;
.source "SourceFile"


# instance fields
.field final synthetic this$1:Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;)V
    .locals 0

    .prologue
    .line 4080
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;

    invoke-direct {p0}, Landroid/widget/Filter;-><init>()V

    return-void
.end method


# virtual methods
.method protected performFiltering(Ljava/lang/CharSequence;)Landroid/widget/Filter$FilterResults;
    .locals 10

    .prologue
    const/4 v1, 0x0

    .line 4083
    new-instance v3, Landroid/widget/Filter$FilterResults;

    invoke-direct {v3}, Landroid/widget/Filter$FilterResults;-><init>()V

    .line 4084
    if-eqz p1, :cond_6

    .line 4085
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    # setter for: Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->img:Ljava/util/ArrayList;
    invoke-static {v0, v2}, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->access$902(Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;Ljava/util/ArrayList;)Ljava/util/ArrayList;

    .line 4086
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 4087
    sget-object v5, Lcom/mixerbox/mixerbox3b/utils/MixerBoxConstants;->ARTISTS:[Ljava/lang/String;

    .line 4088
    sget-object v6, Lcom/mixerbox/mixerbox3b/utils/MixerBoxConstants;->ARTIST_THUMBNAIL:[Ljava/lang/String;

    move v0, v1

    .line 4089
    :goto_0
    array-length v2, v5

    if-ge v0, v2, :cond_3

    .line 4090
    aget-object v2, v5, v0

    sget-object v7, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v2, v7}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v7}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 4091
    aget-object v2, v5, v0

    invoke-virtual {v4, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 4092
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->img:Ljava/util/ArrayList;
    invoke-static {v2}, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->access$900(Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;)Ljava/util/ArrayList;

    move-result-object v2

    aget-object v7, v6, v0

    invoke-virtual {v2, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 4089
    :cond_0
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 4094
    :cond_1
    aget-object v2, v5, v0

    const-string v7, " "

    invoke-virtual {v2, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v7

    move v2, v1

    .line 4095
    :goto_2
    array-length v8, v7

    if-ge v2, v8, :cond_0

    .line 4096
    aget-object v8, v7, v2

    sget-object v9, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v8, v9}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 4097
    aget-object v2, v5, v0

    invoke-virtual {v4, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 4098
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->img:Ljava/util/ArrayList;
    invoke-static {v2}, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->access$900(Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;)Ljava/util/ArrayList;

    move-result-object v2

    aget-object v7, v6, v0

    invoke-virtual {v2, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 4095
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 4105
    :cond_3
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 4106
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    # invokes: Lcom/mixerbox/mixerbox3b/MainPage;->autocomplete(Ljava/lang/String;)Ljava/util/ArrayList;
    invoke-static {v0, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->access$1000(Lcom/mixerbox/mixerbox3b/MainPage;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    .line 4107
    :goto_3
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v1, v2, :cond_4

    .line 4108
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v4, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 4109
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->img:Ljava/util/ArrayList;
    invoke-static {v2}, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->access$900(Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;)Ljava/util/ArrayList;

    move-result-object v2

    const-string v5, ""

    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 4107
    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    .line 4112
    :cond_4
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_5

    .line 4113
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 4114
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->img:Ljava/util/ArrayList;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->access$900(Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;)Ljava/util/ArrayList;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 4118
    :cond_5
    iput-object v4, v3, Landroid/widget/Filter$FilterResults;->values:Ljava/lang/Object;

    .line 4119
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v0

    iput v0, v3, Landroid/widget/Filter$FilterResults;->count:I

    .line 4121
    :cond_6
    return-object v3
.end method

.method protected publishResults(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterResults;)V
    .locals 2

    .prologue
    .line 4126
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1;->this$1:Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1$1;

    invoke-direct {v1, p0, p2}, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1$1;-><init>(Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1;Landroid/widget/Filter$FilterResults;)V

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 4136
    return-void
.end method
